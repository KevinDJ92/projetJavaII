package com.entities;

import java.io.Serializable;
import java.util.Hashtable;

public class Produit implements Serializable{
	private int id;
	private String nom;
	private String detail;
	private int qte;
	private String etat;
	private String categorie;
	private double prix;
	
	//private Hashtable<Integer, Utilisateurs> monPanier;
	public Produit(){}
	public Produit(String nom, String detail, int qte, String etat, String categorie, double prix) {
		super();
		this.nom = nom;
		this.detail = detail;
		this.qte = qte;
		this.etat = etat;
		this.categorie = categorie;
		this.prix = prix;		
	}

	public Produit(int id, String nom, String detail, int qte, String etat, String categorie, double prix) {
		super();
		this.id = id;
		this.nom = nom;
		this.detail = detail;
		this.qte = qte;
		this.etat = etat;
		this.categorie = categorie;
		this.prix = prix;
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
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}

	
	
}
