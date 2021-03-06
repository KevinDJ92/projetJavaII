package com.entities;

import java.io.Serializable;
import java.util.Hashtable;


public class Utilisateur implements Serializable{
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String password;
	private String telNum;
	private String adresse;
	private String codePostal;
	private String secureQ;
	private String repSecureQ;
	private String imgLink;
	
	//private Hashtable<Integer, Utilisateurs> monPanier;
	public Utilisateur(){}
	public Utilisateur(String nom, String prenom, String tel, String adresse, String codePostal, String imgLink) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.telNum = tel;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.imgLink = imgLink;		
	}

	public Utilisateur(int id, String nom, String prenom, String tel, String adresse, String codePostal, String imgLink) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.telNum = tel;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.imgLink = imgLink;
	}

	public Utilisateur(int id, String nom, String prenom, String email, 
			String password, String telephone, String adresse, String codePostal, String secureQ, String repSecureQ, String imgLink) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.password = password;
		this.secureQ = secureQ;
		this.repSecureQ = repSecureQ;
		this.imgLink = imgLink;
	}
	
	public Utilisateur(String nom, String prenom, String email, 
String password, String telephone, String adresse, String codePostal, String questionSecurity, String reponseSecurity, String imgLink) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.email = email;
		this.password = password;
		this.secureQ = secureQ;
		this.repSecureQ = repSecureQ;
		this.imgLink = imgLink;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getTelNum() {
		return telNum;
	}
	
	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}
	
	public String getAdresse() {
		return adresse;
	}
	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public String getCodePostal() {
		return codePostal;
	}
	
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	
	public String getSecureQ() {
		return secureQ;
	}
	
	public void setSecureQ(String secureQ) {
		this.secureQ = secureQ;
	}
	public String getRepSecureQ() {
		return repSecureQ;
	}
	
	public void setRepSecureQ(String repSecureQ) {
		this.repSecureQ = repSecureQ;
	}
	
	public String getImgLink() {
		return imgLink;
	}
	
	public void setImgLink(String imgLink) {
		this.imgLink = imgLink;
	}
}
