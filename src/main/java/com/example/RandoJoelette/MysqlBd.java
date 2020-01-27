package com.example.RandoJoelette;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MysqlBd {
	
	Connection conn;
	
	public MysqlBd() {
		super();
		this.conn = null;
	}
	
	public void connect(String db_userid, String db_password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.conn = DriverManager.getConnection("jdbc:mysql://mysql-dorianmalavergne.alwaysdata.net/dorianmalavergne_randojoelette?"
					+ "user=" + db_userid + "&password=" + db_password);
			this.conn.setAutoCommit(false);
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
	}
	
	public void close() {
		try {
			this.conn.close();
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
	}
	
	public Randonneur connexionRandonneur(String loginSaisi, String passwordSaisi) {
		Statement stmt = null;
		try {
			stmt = this.conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM randonneur");
			
			while(rs.next()) {
				int idRandonneur = rs.getInt("idRandonneur");
				String login = rs.getString("login");
				String password = rs.getString("password");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String adresse = rs.getString("adresse");
				String tel = rs.getString("telephone");
				String asso = rs.getString("statut");
				
				if(login.equals(loginSaisi) && password.equals(passwordSaisi)) {
					rs.close();
					stmt.close();
					return new Randonneur(idRandonneur, login, password, nom, prenom, adresse, tel, asso);
				}
			}

			rs.close();
			stmt.close();
			// L'utilisateur n'a pas été trouvé
			return new Randonneur();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Randonnee> afficheRandonneeActive() {
		List<Randonnee> randonneesExistantes = new ArrayList<Randonnee>();
		Statement stmt = null;
		try {
			stmt = this.conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM randonnee WHERE active=1");
			
			while(rs.next()) {
				int idRandonnee = rs.getInt("idRando");
				String libelle = rs.getString("libelle");
				String date = rs.getString("date");
				String lieu = rs.getString("lieu");
				String dateEcheance = rs.getString("date_echeance");
				int participantMin = rs.getInt("participant_min");
				int participantInscrit = rs.getInt("participant_inscrit");
				int participantHandicape = rs.getInt("participant_handicape");
				int active = rs.getInt("active");
				
				Randonnee randonnee = new Randonnee(idRandonnee, libelle, date, lieu,
						dateEcheance, participantMin, participantInscrit,
						participantHandicape, active);
				
				randonneesExistantes.add(randonnee);
				
			}
			rs.close();
			stmt.close();
			return randonneesExistantes;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
