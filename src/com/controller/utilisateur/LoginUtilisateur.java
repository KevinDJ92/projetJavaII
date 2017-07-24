package com.controller.utilisateur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entities.Utilisateur;
import com.manager.UtilisateursManager;
import com.utils.Constante;
import com.utils.GestionSession;

@WebServlet("/LoginUtilisateur")
public class LoginUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginUtilisateur() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String urlRedirectValid = Constante.pageIndex;
		String urlRedirectInvalid = Constante.pageLogin;
		String emailName = null;
		
		Utilisateur util = new Utilisateur();
		
		util.setEmail(request.getParameter("email"));
		util.setPassword(request.getParameter("password"));
		
		if (UtilisateursManager.userExiste(util)){
			emailName = util.getEmail();
			util = UtilisateursManager.getByEmail(emailName);
			
			GestionSession.ajouterUtilToSession(request, util);
//			if (request.getParameter("sauvegarde") == "yes"){
//			}
			
			//System.out.println("User added to the Session");
			
			request.getRequestDispatcher(urlRedirectValid).forward(request, response);
		}
		
		else {
			request.getRequestDispatcher(urlRedirectInvalid).forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
