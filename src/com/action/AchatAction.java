package com.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.entities.PhotoProduit;
import com.manager.PhotoProduitManager;

public class AchatAction {

	public static boolean afficherPhotoProd(HttpServletRequest request) {

		ArrayList<PhotoProduit> photoProd = PhotoProduitManager.getAll();

		request.setAttribute("listePhotoProd", photoProd);

		return (photoProd != null ? true : false);
	}
}
