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
	public static void gereLePanier(HttpServletRequest request, HttpServletResponse response, 
									OPERATION operation , int quantite, Produit produit) {
		
		HttpSession session=request.getSession(true);
		HashMap<Integer,LigneCommande> monPanier= (HashMap<Integer,LigneCommande>)session.getAttribute("LePanier");
		
		if (monPanier == null) {
			monPanier = new HashMap<Integer,LigneCommande>();
			session.setAttribute("LePanier", monPanier);
		}
		
		if (operation.equals(OPERATION.AJOUTER)) {
			ManagerLigneCommande.addProduit(quantite, produit, monPanier);
		}
		else {
			ManagerLigneCommande.removeProduit(produit, quantite, monPanier);
		}
		
		int nombreArticle = ManagerLigneCommande.getNombreArticle(monPanier);
		
		request.setAttribute("nombreArticle", nombreArticle);
		
		try {
			request.getRequestDispatcher("AfficheVuePanier").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
