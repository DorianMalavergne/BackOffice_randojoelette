package com.example.RandoJoelette;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
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
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.conn = DriverManager.getConnection("jdbc:mysql://mysql-dorianmalavergne.alwaysdata.net/dorianmalavergne_randojoelette?"
					+ "user=" + db_userid + "&password=" + db_password
					+ "&serverTimezone=UTC");
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

	public Randonnee getRandonnee(String name) {
		Statement stmt = null;
		try {
			stmt = this.conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM randonnee WHERE libelle='" + name + "'");

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

				return randonnee;
			}
			rs.close();
			stmt.close();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Randonnee getRandonneeById(int idRando) {
		Statement stmt = null;
		try {
			stmt = this.conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM randonnee WHERE idRando='" + idRando + "'");

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

				return randonnee;
			}
			rs.close();
			stmt.close();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Randonnee> getRandonneurRandonnee(int idRandonneur) {
		List<Randonnee> randonneurRandonnee = new ArrayList<Randonnee>();
		Statement stmt = null;
		try {
			stmt = this.conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM randonnee "
					+ "JOIN randonneurRandonnee "
					+ "ON randonnee.idRando = randonneurRandonnee.idRandonnee "
					+ "JOIN randonneur "
					+ "ON randonneur.idRandonneur = randonneurRandonnee.idRandonneur "
					+ "WHERE randonneur.idRandonneur = " + idRandonneur + ";");

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

				randonneurRandonnee.add(randonnee);
			}

			rs.close();
			stmt.close();
			return randonneurRandonnee;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Randonneur inscription(String log, String pass, String nom, String prenom, String add, String tel, String stat) {
		Statement stmt = null;
		String sql = ("INSERT INTO randonneur (login, password, nom, prenom, adresse, telephone, statut)"
				+ " VALUES ('"
				+ log    + "', '"
				+ pass   + "', '"
				+ nom    + "', '"
				+ prenom + "', '"
				+ add    + "', '"
				+ tel    + "', '"
				+ stat   + "')");
		try {
			stmt = this.conn.createStatement();
			stmt.executeUpdate(sql);
			Randonneur randonneur = new Randonneur(0, log, pass, nom, prenom, add, tel , stat);
			this.conn.commit();
			this.conn.close();
			return randonneur;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Randonnee valideParticipation(int idRandonneur, int idRandonnee) {
		Statement stmt = null;
		String sql = "INSERT INTO randonneurRandonnee (idRandonneur, idRandonnee) VALUES(" + idRandonneur + ", " + idRandonnee + ")";
		
		try {
			stmt = this.conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
			this.conn.commit();
			return getRandonneeById(idRandonnee);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Randonnee annuleParticipation(int idRandonneur, int idRandonnee) {
		Statement stmt = null;
		String sql = "DELETE FROM randonneurRandonnee"
				+ " WHERE idRandonneur=" + idRandonneur
				+ " AND idRandonnee=" + idRandonnee;
		
		try {
			stmt = this.conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
			this.conn.commit();
			return getRandonneeById(idRandonnee);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Randonnee ajoutRando(String libelle, String date, String lieu, String date_echeance, int participants_min, int participants_inscrits, int participants_handicapes, int active) {
		Statement stmt = null;
		String sql = ("INSERT INTO randonnee (libelle, date, lieu, date_echeance, participant_min, participant_inscrit, participant_handicape, active)"
				+ " VALUES ('"
				+ libelle    + "', '"
				+ date   + "', '"
				+ lieu    + "', '"
				+ date_echeance + "', '"
				+ participants_min    + "', '"
				+ participants_inscrits    + "', '"
				+ participants_handicapes    + "', '"
				+ active   + "')");
		try {
			stmt = this.conn.createStatement();
			stmt.executeUpdate(sql);
			Randonnee rando = new Randonnee(0, libelle, date, lieu, date_echeance, participants_min, participants_inscrits , participants_handicapes, active);
			this.conn.commit();
			this.conn.close();
			return rando;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Randonnee ajoutParticipant(int idRandonnee) {
		Statement stmt = null;
		String sql = "UPDATE randonnee" + 
				" SET participant_inscrit = participant_inscrit+1" + 
				" WHERE idRando=" + idRandonnee;
		
		try {
			stmt = this.conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
			this.conn.commit();
			return getRandonneeById(idRandonnee);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
