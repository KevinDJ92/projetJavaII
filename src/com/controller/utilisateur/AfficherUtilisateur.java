package com.controller.utilisateur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utils.Constante;


@WebServlet("/AfficherUtilisateur")
public class AfficherUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AfficherUtilisateur() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String urlRedirect = Constante.cefErrorPage;
	
		String nom = request.getParameter("nomInsert");
		String prenom = request.getParameter("prenomInsert");
		String email = request.getParameter("emailInsert");
		String password = request.getParameter("passwordInsert");
		String passwordConfirm = request.getParameter("passwordConfirmInsert");
		String telephone = request.getParameter("telephoneInsert");
		String adresse = request.getParameter("adresseInsert");
		String codePostal = request.getParameter("codePostalInsert");
		String questionSecurity = request.getParameter("questionSecurityInsert");
		String reponseSecurity = request.getParameter("reponseSecurityInsert");	
		String imglink = request.getParameter("imgLinkInsert");	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
