package com.controller.utilisateur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.UtilisateurAction;

@WebServlet("/SupprimerUtilisateur")
public class SupprimerUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SupprimerUtilisateur() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idUtil = Integer.parseInt(request.getParameter("id"));
		
		UtilisateurAction.deleteUtilisateur(idUtil);
		
		request.getRequestDispatcher("/afficherEtudiant").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
