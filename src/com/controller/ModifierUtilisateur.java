package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.UtilisateurAction;
import com.entities.Utilisateur;
import com.manager.UtilisateursManager;
import com.utils.Constante;
import com.utils.GestionSession;
@WebServlet(name = "ModifierUtilisateur", urlPatterns = { "/ModifierUtilisateur" })
public class ModifierUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModifierUtilisateur() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur utils = (Utilisateur) request.getSession().getAttribute(Constante.clefSession);
		System.out.println("Utilisateur: " + utils);
		
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

		System.out.println(nom + " " + prenom + " " + email + " " + password + " " + passwordConfirm + " " +telephone + " " + adresse + " " + codePostal);
		
		if (password.equals(passwordConfirm)){
			if(utils != null){
				Utilisateur util = new Utilisateur(utils.getId(), nom, prenom, email, password, telephone, adresse, codePostal, questionSecurity, reponseSecurity, imglink);			
				UtilisateurAction.updateUtilisateur(util);
				System.out.println("\nupdate");
			} else {
				Utilisateur util = new Utilisateur(nom, prenom, email, password, telephone, adresse, codePostal, questionSecurity, reponseSecurity, imglink);			
				UtilisateurAction.insertUtilisateur(util);	
				System.out.println("\ninsert");
			}
	}
	}
}