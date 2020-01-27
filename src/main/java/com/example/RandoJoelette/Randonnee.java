package com.example.RandoJoelette;

public class Randonnee {

	private int idRando;
	private String libelle;
	private String date;
	private String lieu;
	private String dateEcheance;
	private int participantMin;
	private int participantInscrit;
	private int participantHandicape;
	private int active;
	public Randonnee(int idRando, String libelle, String date, String lieu, String dateEcheance, int participantMin,
			int participantInscrit, int participantHandicape, int active) {
		this.idRando = idRando;
		this.libelle = libelle;
		this.date = date;
		this.lieu = lieu;
		this.dateEcheance = dateEcheance;
		this.participantMin = participantMin;
		this.participantInscrit = participantInscrit;
		this.participantHandicape = participantHandicape;
		this.active = active;
	}
	public int getIdRando() {
		return idRando;
	}
	public void setIdRando(int idRando) {
		this.idRando = idRando;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public String getDateEcheance() {
		return dateEcheance;
	}
	public void setDateEcheance(String dateEcheance) {
		this.dateEcheance = dateEcheance;
	}
	public int getParticipantMin() {
		return participantMin;
	}
	public void setParticipantMin(int participantMin) {
		this.participantMin = participantMin;
	}
	public int getParticipantInscrit() {
		return participantInscrit;
	}
	public void setParticipantInscrit(int participantInscrit) {
		this.participantInscrit = participantInscrit;
	}
	public int getParticipantHandicape() {
		return participantHandicape;
	}
	public void setParticipantHandicape(int participantHandicape) {
		this.participantHandicape = participantHandicape;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	
	
	
	
}
