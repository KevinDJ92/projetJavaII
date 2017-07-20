package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.ActionLigneCommande;
import com.entities.Produit;

@WebServlet("/GererPanier")
public class GererPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GererPanier() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String operation = request.getParameter("btsubmit");
//		int quantite = Integer.parseInt(request.getParameter("quantite"));
//		int stock = Integer.parseInt(request.getParameter("stock"));
//		double prix  =Double.parseDouble(request.getParameter("prix"));
//		int id = Integer.parseInt(request.getParameter("id"));
//		String libelle = request.getParameter("libelle");
		//String format=request.getParameter("format");
		
//		Produit produit=new Produit();
//		
//		produit.setFormat(format);
//		produit.setId(id);
//		produit.setLibelle(libelle);
//		produit.setPrix(prix);
//		produit.setStock(stock);
		
//		ActionLigneCommande.gereLePanier(request, response, operation, quantite, produit);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
