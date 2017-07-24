package com.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.ActionLigneCommande;
import com.action.ProduitAction;
import com.entities.LigneCommande;
import com.manager.ManagerLigneCommande;

@WebServlet("/AfficheVuePanier")
public class AfficheVuePanier extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AfficheVuePanier() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (ActionLigneCommande.afficherLePanier(request)){
			ActionLigneCommande.getNombreArticle(request);
		}
		
		try {
			request.getRequestDispatcher("vuePanier.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
