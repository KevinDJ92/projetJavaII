package com.controller.panier;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.action.ActionLigneCommande;
import com.action.ProduitAction;
import com.entities.Produit;
import com.manager.ProduitManager;
import com.utils.Constante;

@WebServlet("/GererPanier")
public class GererPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public GererPanier() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("btsubmit");
		int id = Integer.parseInt(request.getParameter("idProduit"));
		int quantite = Integer.parseInt(request.getParameter("quantite"));
		HttpSession session = request.getSession(true); 
	
		if(session.getAttribute(Constante.clefSession) == null){
    		response.sendRedirect("Login.jsp");
    	}
		else {
			if(ProduitAction.afficherProduitParId(request, id)){
				ArrayList<Produit> produits = (ArrayList<Produit>) request.getAttribute("listeProd");
	
				Produit produit = produits.get(0);
		
				ActionLigneCommande.gereLePanier(request, response, session, operation, quantite, produit);
				response.sendRedirect("produits.jsp");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
