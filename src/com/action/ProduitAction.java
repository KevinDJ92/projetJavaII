package com.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.entities.Produit;
import com.manager.ProduitManager;

public class ProduitAction {

	public static boolean afficherProduit(HttpServletRequest request) {

		ArrayList<Produit> produits = ProduitManager.getAll();

		request.setAttribute("listeProd", produits);

		return (produits != null ? true : false);
	}
	
	public static boolean afficherProduitParCategorie(HttpServletRequest request,String categorie) {

		ArrayList<Produit> produits = ProduitManager.getByCategorie(categorie);

		request.setAttribute("listeProd", produits);

		return (produits != null ? true : false);
	}
	
	public static boolean afficherProduitParId(HttpServletRequest request,int id) {

		ArrayList<Produit> produits = ProduitManager.getById(id);

		request.setAttribute("listeProd", produits);

		return (produits != null ? true : false);
	}
	
	public static boolean afficherProduitParNom(HttpServletRequest request,String name) {

		ArrayList<Produit> produits = ProduitManager.getByName(name);

		request.setAttribute("listeProd", produits);

		return (produits != null ? true : false);
	}
	
	public static boolean afficherProduitParEtat(HttpServletRequest request,String etat) {

		ArrayList<Produit> produits = ProduitManager.getByEtat(etat);

		request.setAttribute("listeProd", produits);

		return (produits != null ? true : false);
	}
	
	public static boolean afficherProduitParPrix(HttpServletRequest request,double prix) {

		ArrayList<Produit> produits = ProduitManager.getByPrice(prix);

		request.setAttribute("listeProd", produits);

		return (produits != null ? true : false);
	}
	
	public static boolean afficherProduitPrixMinMax(HttpServletRequest request,double prixMin,double prixMax) {

		ArrayList<Produit> produits = ProduitManager.getByPriceBetween(prixMin, prixMax);

		request.setAttribute("listeProd", produits);

		return (produits != null ? true : false);
	}
	
	public static boolean insertProduit(Produit prodToAdd) {
		boolean retour = false;

		if (ProduitManager.insertAndRecupId(prodToAdd)) {
			retour = true;
		}

		return retour;
	}
	
	public static boolean updateProduit(Produit prodToUpdate) {
		boolean retour = false;

		if (ProduitManager.update(prodToUpdate)) {
			retour = true;
		}

		return retour;
	}
	
	public static boolean deleteProd(int idProd) {
		boolean retour = false;

		if (ProduitManager.delete(idProd)) {
			retour = true;
		}

		return retour;
	}
	
}
