package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.AchatAction;
import com.entities.Utilisateur;
import com.utils.Constante;

@WebServlet("/AfficherAchat")
public class AfficherAchat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AfficherAchat() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute(Constante.clefSession);
		int id = utilisateur.getId();
		
		if (AchatAction.afficherAchat(request, id)){
			request.getRequestDispatcher("achats.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
