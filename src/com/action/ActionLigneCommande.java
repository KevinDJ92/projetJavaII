package com.action;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entities.LigneCommande;
import com.entities.Produit;
import com.manager.ManagerLigneCommande;
import com.enumeration.OPERATION;

public class ActionLigneCommande {
	@SuppressWarnings("unchecked")
	public static void gereLePanier(HttpServletRequest request, HttpServletResponse response, HttpSession session,
									String operation , int quantite, Produit produit) {
		
		HashMap<Integer,LigneCommande> monPanier = (HashMap<Integer,LigneCommande>) session.getAttribute("LePanier");
		
		if (monPanier == null) {
			monPanier = new HashMap<Integer,LigneCommande>();
			session.setAttribute("LePanier", monPanier);
		}
				
		if (operation.equals("Ajouter au Panier")) {

			ManagerLigneCommande.addProduit(quantite, produit, monPanier);
		}
	}
	
	public static boolean afficherLePanier(HttpServletRequest request){
		HttpSession session = request.getSession(true);
		HashMap<Integer,LigneCommande> monPanier = (HashMap<Integer,LigneCommande>) session.getAttribute("LePanier");
	
		request.setAttribute("monPanier", monPanier);
		
		return (monPanier != null ? true : false);
	}
	
	public static boolean getNombreArticle(HttpServletRequest request){
		HttpSession session = request.getSession(true);

		int nombreArticle = ManagerLigneCommande.getNombreArticle((HashMap<Integer, LigneCommande>)request.getAttribute("monPanier"));
		request.setAttribute("nombreArticle", nombreArticle);
		
		return (nombreArticle > 0 ? true : false);
	}
	
	public static void suprimerProdPanier(HttpServletRequest request, HttpSession session,int idProduit) {

			HashMap<Integer,LigneCommande> monPanier = (HashMap<Integer,LigneCommande>) session.getAttribute("LePanier");
			
			ManagerLigneCommande.removeProduit(idProduit, monPanier);
			
		
			
	}
	
}
