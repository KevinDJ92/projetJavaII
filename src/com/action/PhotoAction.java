package com.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.entities.PhotoProduit;
import com.manager.PhotoProduitManager;

public class PhotoAction {
	//private  ArrayList<PhotoProduit> photoPro= new ArrayList<>();
	public static boolean afficherPhotoProd(HttpServletRequest request) {

		ArrayList<PhotoProduit> photoProd = PhotoProduitManager.getAll();

		request.setAttribute("listePhotoProd", photoProd);

		return (photoProd != null ? true : false);
	}
	
	public static boolean afficherPhotoProdwithId(HttpServletRequest request,int id) {

		ArrayList<PhotoProduit> photoProd = PhotoProduitManager.getByIdProduit(id);

		request.setAttribute("listePhotoProd", photoProd);

		return (photoProd != null ? true : false);
	}
	
	public static boolean insertPhotoProd(PhotoProduit photoProd) {
		boolean retour = false;

		if (PhotoProduitManager.insert(photoProd)) {
			retour = true;
		}

		return retour;
	}

	public static boolean updatePhotoProd(PhotoProduit photoProd) {
		boolean retour = false;

		if (PhotoProduitManager.update(photoProd)) {
			retour = true;
		}

		return retour;
	}

	public static boolean deletePhotoProd(int idPhoto){
		boolean retour= false;		
		
		if(PhotoProduitManager.delete(idPhoto))
			retour =true;
		
		return retour;
	}

}
