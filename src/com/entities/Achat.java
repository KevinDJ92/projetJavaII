package com.entities;

import java.io.Serializable;
import java.util.Date;

public class Achat implements Serializable{

	private int idAchat;
	private int idUtil;
	private int idProd;
	private String confimNum;
	private Date dateAchat;
	private String adresseExp;
	private String suivi;
	
	public Achat(){}

	public Achat(int idAchat, int idUtil, int idProd, String confimNum, Date dateAchat, String adresseExp,
			String suivi) {
		super();
		this.idAchat = idAchat;
		this.idUtil = idUtil;
		this.idProd = idProd;
		this.confimNum = confimNum;
		this.dateAchat = dateAchat;
		this.adresseExp = adresseExp;
		this.suivi = suivi;
	}

	public Achat(String confimNum, Date dateAchat, String adresseExp, String suivi) {
		super();
		this.confimNum = confimNum;
		this.dateAchat = dateAchat;
		this.adresseExp = adresseExp;
		this.suivi = suivi;
	}

	public Achat(String confimNum, Date dateAchat, String suivi) {
		super();
		this.confimNum = confimNum;
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

	public String getConfimNum() {
		return confimNum;
	}

	public void setConfimNum(String confimNum) {
		this.confimNum = confimNum;
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
