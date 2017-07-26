package com.entities;

import java.util.Date;

public class AchatProduit {
	private int idAchat;
	private String nomAchat;
	private String prixAchat;
	private String detailAchat;
	private int quantiteAchat;
	private Date dateAchat;
	
	public AchatProduit() {
		super();
	}
	
	public AchatProduit(int idAchat, String nomAchat, String prixAchat, String detailAchat, int quantiteAchat,
			Date dateAchat) {
		super();
		this.idAchat = idAchat;
		this.nomAchat = nomAchat;
		this.prixAchat = prixAchat;
		this.detailAchat = detailAchat;
		this.quantiteAchat = quantiteAchat;
		this.dateAchat = dateAchat;
	}
	
	public AchatProduit(String nomAchat, String prixAchat, String detailAchat, int quantiteAchat,
			Date dateAchat) {
		super();
		this.nomAchat = nomAchat;
		this.prixAchat = prixAchat;
		this.detailAchat = detailAchat;
		this.quantiteAchat = quantiteAchat;
		this.dateAchat = dateAchat;
	}
	
	public int getIdAchat() {
		return idAchat;
	}
	
	public void setIdAchat(int idAchat) {
		this.idAchat = idAchat;
	}
	
	public String getNomAchat() {
		return nomAchat;
	}
	
	public void setNomAchat(String nomAchat) {
		this.nomAchat = nomAchat;
	}
	
	public String getPrixAchat() {
		return prixAchat;
	}
	
	public void setPrixAchat(String prixAchat) {
		this.prixAchat = prixAchat;
	}
	
	public String getDetailAchat() {
		return detailAchat;
	}
	
	public void setDetailAchat(String detailAchat) {
		this.detailAchat = detailAchat;
	}
	
	public int getQuantiteAchat() {
		return quantiteAchat;
	}
	
	public void setQuantiteAchat(int quantiteAchat) {
		this.quantiteAchat = quantiteAchat;
	}
	
	public Date getDateAchat() {
		return dateAchat;
	}
	
	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}	
}
