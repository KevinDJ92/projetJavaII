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

/**
 * Servlet implementation class AjoutAchat
 */
@WebServlet("/ajoutAchat")
public class AjoutAchat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutAchat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		ArrayList<Achat> achats = new ArrayList();
		
		HashMap<Integer,LigneCommande> monPanier=(HashMap<Integer,LigneCommande>)request.getSession().getAttribute("LePanier");
		for(Map.Entry<Integer, LigneCommande> entry : monPanier.entrySet()){
			
				
				Utilisateur util = ((Utilisateur)request.getSession().getAttribute(Constante.clefSession));
                Achat achat = new Achat(util.getId(),entry.getValue().getProduit().getId(),
             		   			"abc123",null,"dfsdf","envoyer",entry.getValue().getQuantite());
               
                achats.add(achat);
			
			
		}
		
		System.out.println(achats);
		if(achats != null) {
			for(Achat achat : achats) {
				System.out.println("tester ajout achat idUtil "+ achat.getIdUtil());
				AchatAction.ajoutAchat(achat);
			}
			
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	public static void ajoutAchat(Achat achat) {
		
	}

}
