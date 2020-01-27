package com.example.RandoJoelette;

public class Randonneur {
	
	private int idRandonneur;
	private String login;
	private String password;
	private String nom;
	private String prenom;
	private String adresse;
	private String tel;
	private String statut;
	
	public Randonneur() {
		
	}
	
	public Randonneur(int idRandonneur, String login, String password, String nom, String prenom, String adresse,
			String tel, String asso) {
		this.idRandonneur = idRandonneur;
		this.login = login;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.tel = tel;
		this.statut = asso;
	}


	public int getIdRandonneur() {
		return idRandonneur;
	}


	public void setIdRandonneur(int idRandonneur) {
		this.idRandonneur = idRandonneur;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}
}
