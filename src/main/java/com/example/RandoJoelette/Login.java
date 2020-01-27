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
}