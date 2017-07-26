package com.controller;

import java.io.IOException;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.AchatAction;
import com.entities.Achat;
import com.entities.LigneCommande;
import com.entities.Utilisateur;
import com.utils.Constante;
import com.utils.GestionMail;

/**
 * Servlet implementation class AjoutAchat
 */
@WebServlet("/ajoutAchat")
public class AjoutAchat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjoutAchat() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ArrayList<Achat> achats = new ArrayList();
		
		HashMap<Integer,LigneCommande> monPanier=(HashMap<Integer,LigneCommande>)request.getSession().getAttribute("LePanier");
		
		Utilisateur util = ((Utilisateur)request.getSession().getAttribute(Constante.clefSession));
		String msg = "<h1>Merci d'avoir magaziner chez nous</h1>";
		String to = util.getEmail();
		String sujet = "Confirmation de votre achat";
		for(Map.Entry<Integer, LigneCommande> entry : monPanier.entrySet()){
			
				
				
                Achat achat = new Achat(util.getId(),entry.getValue().getProduit().getId(),
             		   			"abc123",null,"dfsdf","envoyer",entry.getValue().getQuantite());
               
                achats.add(achat);
                msg+="<p>nom de l'article " +entry.getValue().getProduit().getNom() +"</p>\r\n" + 
						"	                    	<p>La quantité de votre commande est :"+entry.getValue().getQuantite()+"</p>\r\n" + 
						"	                    	<p>Le prix total pour cette article est "+entry.getValue().getQuantite()+" * "+entry.getValue().getProduit().getPrix()+" = "+entry.getValue().getQuantite()*entry.getValue().getProduit().getPrix()+"$</p>\r\n" + 
						"	                  <hr color=\"black\"> ";
			
			
		}
		
		System.out.println(achats);
		if(achats != null) {
			
			
			for(Achat achat : achats) {
				
				AchatAction.ajoutAchat(achat);
				
			}
			response.sendRedirect("achats.jsp");
			GestionMail.sendEmail(msg, to, sujet);
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
