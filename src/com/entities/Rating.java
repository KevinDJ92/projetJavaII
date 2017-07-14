package com.entities;

import java.io.Serializable;
import java.util.Date;

public class Rating implements Serializable{
	private int idUtil;
	private int idProduit;
	private int note;
	private String commentaire;
	private Date date;
	//private Hashtable<Integer, Utilisateurs> monPanier;
	public Rating(){}
	public Rating(String nom, String prenom, int idProduit, int note, String categorie, int idUtil,java.sql.Date date) {
		super();
		this.idUtil = idUtil;	
		this.idProduit = idProduit;
		this.note = note;
		this.commentaire = categorie;
		this.date = date;
			
	}

	public Rating( int note, String commentaire,java.sql.Date date) {
		super();
		this.note = note;
		this.commentaire = commentaire;
		this.date = date;
	}
	public int getIdUtil() {
		return idUtil;
	}
	public void setIdUtil(int idUtil) {
		this.idUtil = idUtil;
	}
	public int getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
