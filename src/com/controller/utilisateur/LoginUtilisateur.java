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

@WebServlet("/LoginUtilisateur")
public class LoginUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginUtilisateur() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String urlRedirect = Constante.pageIndex;
		
		Utilisateur util = new Utilisateur();
		
		util.setEmail(request.getParameter("email"));
		util.setPassword(request.getParameter("password"));
		
		if (UtilisateursManager.userExiste(util)){
			request.getRequestDispatcher(urlRedirect).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
