package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.PhotoAction;
import com.action.ProduitAction;
import com.action.RatingAction;
import com.utils.Constante;

@WebServlet("/AfficherCategorieProd")
public class AfficherCategorieProd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AfficherCategorieProd() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String urlRedirect = Constante.cefErrorPage;
		String linkR = (String)request.getAttribute("link");

		//System.out.println(linkR);
		
		if(linkR == null){
			request.setAttribute("listeCategorieValid", "true");
			linkR = "index.jsp";
		}
		
		if(ProduitAction.afficherCategoriesProd(request)){
			urlRedirect = linkR;
			request.setAttribute("listeCategorieValid", "true");
			request.getRequestDispatcher(urlRedirect).forward(request, response);
			
		}
		
		
//		request.getRequestDispatcher(urlRedirect).forward(request, response);
	

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public static boolean RecupererAllCategorie(HttpServletRequest request){
		request.setAttribute("listeCategorieValid", "true");

		return ProduitAction.afficherCategoriesProd(request);
	}

}
