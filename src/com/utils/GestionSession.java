package com.utils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.entities.Utilisateur;



public class GestionSession {
	
public void ajouterEtudianToSession(HttpServletRequest request,Utilisateur utilisateur ){
		
		HttpSession mySession = request.getSession(); 
		mySession.setAttribute(Constante.clefSession,utilisateur);
		
	}
public static void detruireSession(HttpServletRequest request,HttpServletResponse response) {
	
	HttpSession session=request.getSession();
	    session.invalidate();
	
	try {
		request.getRequestDispatcher("login.jsp").forward(request, response);
		
	} catch (ServletException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
