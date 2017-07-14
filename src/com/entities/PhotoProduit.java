package com.entities;

public class PhotoProduit {

	private int idPic;
	private int idProd;
	private String cheminFtp;
	private String extensionPic;
	private String alt;
	private int isDefault;
	
	
	public PhotoProduit() {}

	public PhotoProduit(int idPic, int idProd, String cheminFtp, String extensionPic, String alt, int isDefault) {
		super();
		this.idPic = idPic;
		this.idProd = idProd;
		this.cheminFtp = cheminFtp;
		this.extensionPic = extensionPic;
		this.alt = alt;
		this.isDefault = isDefault;
	}

	public PhotoProduit(String cheminFtp, String extensionPic, String alt, int isDefault) {
		super();
		this.cheminFtp = cheminFtp;
		this.extensionPic = extensionPic;
		this.alt = alt;
		this.isDefault = isDefault;
	}

	public PhotoProduit(String cheminFtp, String extensionPic, String alt) {
		super();
		this.cheminFtp = cheminFtp;
		this.extensionPic = extensionPic;
		this.alt = alt;
	}

	public int getIdPic() {
		return idPic;
	}

	public void setIdPic(int idPic) {
		this.idPic = idPic;
	}

	public int getIdProd() {
		return idProd;
	}

	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}

	public String getCheminFtp() {
		return cheminFtp;
	}

	public void setCheminFtp(String cheminFtp) {
		this.cheminFtp = cheminFtp;
	}

	public String getExtensionPic() {
		return extensionPic;
	}

	public void setExtensionPic(String extensionPic) {
		this.extensionPic = extensionPic;
	}

	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	public int getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(int isDefault) {
		this.isDefault = isDefault;
	}
	
	
	
	
	
}
