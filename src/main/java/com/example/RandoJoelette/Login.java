package com.example.RandoJoelette;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Login {
	
	@CrossOrigin(origins = "*")
	@GetMapping("/connexionUtilisateur")
	public String connexionUtilisateur(@RequestParam String login, @RequestParam String password) {
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			MysqlBd bd = new MysqlBd();
			bd.connect("198699_admin", "Adminrando123");
			Randonneur randonneurConnexion = bd.connexionRandonneur(login, password);
			String reponse = mapper.writeValueAsString(randonneurConnexion);
			bd.close();
			return reponse;
		} catch (Exception e) {
			return null;
		}
	}
	
	@CrossOrigin(origins= "*")
	@GetMapping("/afficheRandonneeActive")
	public String afficheRandonneeActive() {
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			MysqlBd bd = new MysqlBd();
			bd.connect("198699_admin", "Adminrando123");
			List<Randonnee> randonneesActives = bd.afficheRandonneeActive();
			String reponse = mapper.writeValueAsString(randonneesActives);
			bd.close();
			return reponse;
		} catch (Exception e) {
			return null;
		}
	}
	
	@CrossOrigin(origins= "*")
	@GetMapping("/getRandonnee")
	public String getRandonnee(@RequestParam String name) {
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			MysqlBd bd = new MysqlBd();
			bd.connect("198699_admin", "Adminrando123");
			Randonnee randonnee = bd.getRandonnee(name);
			String reponse = mapper.writeValueAsString(randonnee);
			bd.close();
			return reponse;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@CrossOrigin(origins= "*")
	@GetMapping("/getRandonneeById")
	public String getRandonneeById(@RequestParam int idRandonnee) {
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			MysqlBd bd = new MysqlBd();
			bd.connect("198699_admin", "Adminrando123");
			Randonnee randonnee = bd.getRandonneeById(idRandonnee);
			String reponse = mapper.writeValueAsString(randonnee);
			bd.close();
			return reponse;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/getRandonneurRandonnee")
	public String getRandonneurRandonnee(@RequestParam int idRandonneur) {
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			MysqlBd bd = new MysqlBd();
			bd.connect("198699_admin", "Adminrando123");
			List<Randonnee> randonnees = bd.getRandonneurRandonnee(idRandonneur);
			String reponse = mapper.writeValueAsString(randonnees);
			bd.close();
			return reponse;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@CrossOrigin(origins= "*")
	@GetMapping("/inscriptionRandonneur")
	public String inscriptionRandonneur(@RequestParam String login, @RequestParam String password, @RequestParam String nom, @RequestParam String prenom ,@RequestParam String add, @RequestParam String tel, @RequestParam String stat) {
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			MysqlBd bd = new MysqlBd();
			bd.connect("198699_admin", "Adminrando123");
			Randonneur randonneur = bd.inscription(login, password, nom, prenom, add, tel, stat);
			String reponse = mapper.writeValueAsString(randonneur);
			bd.close();
			return reponse;
		} catch (Exception e) {
			return null;
		}
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/valideParticipation")
	public String valideParticipation(@RequestParam int idRandonneur, @RequestParam int idRandonnee) {
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			MysqlBd bd = new MysqlBd();
			bd.connect("198699_admin", "Adminrando123");
			Randonnee randonnee = bd.valideParticipation(idRandonneur, idRandonnee);
			String reponse = mapper.writeValueAsString(randonnee);
			bd.close();
			return reponse;
		} catch(Exception e) {
			return null;
		}
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/annuleParticipation")
	public String annuleParticipation(@RequestParam int idRandonneur, @RequestParam int idRandonnee) {
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			MysqlBd bd = new MysqlBd();
			bd.connect("198699_admin", "Adminrando123");
			Randonnee randonnee = bd.annuleParticipation(idRandonneur, idRandonnee);
			String reponse = mapper.writeValueAsString(randonnee);
			bd.close();
			return reponse;
		} catch(Exception e) {
			return null;
		}
	}
	
	@CrossOrigin(origins= "*")
	@GetMapping("/ajoutRandonnee")
	public String ajoutRandonnee(@RequestParam String libelle, @RequestParam String date, @RequestParam String lieu, @RequestParam String date_echeance, @RequestParam int participants_min, @RequestParam int participants_inscrits, @RequestParam int participants_handicapes, @RequestParam int active) {
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			MysqlBd bd = new MysqlBd();
			bd.connect("198699_admin", "Adminrando123");
			Randonnee rando = bd.ajoutRando(libelle, date, lieu, date_echeance, participants_min, participants_inscrits, participants_handicapes, active);
			String reponse = mapper.writeValueAsString(rando);
			bd.close();
			return reponse;
		} catch (Exception e) {
			return null;
		}
	}
	
	@CrossOrigin(origins= "*")
	@GetMapping("/ajoutParticipant")
	public String ajoutParticipant(@RequestParam int idRandonnee) {
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			MysqlBd bd = new MysqlBd();
			bd.connect("198699_admin", "Adminrando123");
			Randonnee rando = bd.ajoutParticipant(idRandonnee);
			String reponse = mapper.writeValueAsString(rando);
			bd.close();
			return reponse;
		} catch (Exception e) {
			return null;
		}
	}
}
