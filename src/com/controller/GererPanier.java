package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.ActionLigneCommande;
import com.entities.Produit;
import com.manager.ProduitManager;

@WebServlet("/GererPanier")
public class GererPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GererPanier() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom;
	
		int id = Integer.parseInt(request.getParameter("id"));
		int quantite = Integer.parseInt(request.getParameter("quantite"));	

		 ArrayList<Produit> produits = ProduitManager.getById(id);
		 Produit produit = produits.get(0);
		
//		ActionLigneCommande.gereLePanier(request, response, operation, quantite, produit);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
