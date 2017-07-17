package com.entities;

import java.io.Serializable;
import java.util.Date;

public class Achat implements Serializable{
	private int idAchat;
	private int idUtil;
	private int idProd;
	private String confirmNum;
	private Date dateAchat;
	private String adresseExp;
	private String suivi;
	
	public Achat(){}

	public Achat(int idAchat, int idUtil, int idProd, String confirmNum, Date dateAchat, String adresseExp,
			String suivi) {
		super();
		this.idAchat = idAchat;
		this.idUtil = idUtil;
		this.idProd = idProd;
		this.confirmNum = confirmNum;
		this.dateAchat = dateAchat;
		this.adresseExp = adresseExp;
		this.suivi = suivi;
	}

	public Achat(String confirmNum, Date dateAchat, String adresseExp, String suivi) {
		super();
		this.confirmNum = confirmNum;
		this.dateAchat = dateAchat;
		this.adresseExp = adresseExp;
		this.suivi = suivi;
	}

	public Achat(String confirmNum, Date dateAchat, String suivi) {
		super();
		this.confirmNum = confirmNum;
		this.dateAchat = dateAchat;
		this.suivi = suivi;
	}

	public int getIdAchat() {
		return idAchat;
	}

	public void setIdAchat(int idAchat) {
		this.idAchat = idAchat;
	}

	public int getIdUtil() {
		return idUtil;
	}

	public void setIdUtil(int idUtil) {
		this.idUtil = idUtil;
	}

	public int getIdProd() {
		return idProd;
	}

	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}

	public String getConfirmNum() {
		return confirmNum;
	}

	public void setConfirmNum(String confirmNum) {
		this.confirmNum = confirmNum;
	}

	public Date getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}

	public String getAdresseExp() {
		return adresseExp;
	}

	public void setAdresseExp(String adresseExp) {
		this.adresseExp = adresseExp;
	}

	public String getSuivi() {
		return suivi;
	}

	public void setSuivi(String suivi) {
		this.suivi = suivi;
	}
	
	
	
}
