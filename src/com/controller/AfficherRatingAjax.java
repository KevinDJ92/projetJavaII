package com.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.action.RatingAction;
import com.entities.Rating;
import com.entities.Utilisateur;
import com.utils.Constante;

@WebServlet("/afficherRatingAjax")
public class AfficherRatingAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AfficherRatingAjax() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idProd = Integer.parseInt(request.getParameter("id_prod"));
		int starNumber = Integer.parseInt(request.getParameter("star_number"));
	
		System.out.println("idProd" + idProd);
		System.out.println("starNumber" + starNumber);

		HttpSession session = request.getSession(true);
		Utilisateur util = (Utilisateur) session.getAttribute(Constante.clefSession);
	
		Rating rating = new Rating(util.getId(), idProd, starNumber, "");
		
		RatingAction.updateRating(rating);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
