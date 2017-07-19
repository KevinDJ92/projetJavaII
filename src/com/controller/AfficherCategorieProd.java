package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.ProduitAction;
import com.action.RatingAction;
import com.utils.Constante;

/**
 * Servlet implementation class AfficherCategorieProd
 */
@WebServlet("/AfficherCategorieProd")
public class AfficherCategorieProd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficherCategorieProd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String urlRedirect = Constante.cefErrorPage;
		String linkR = request.getParameter("link");

		
		
		if(linkR == null){
			linkR = "index.jsp";
		}
		
		if(ProduitAction.afficherCategoriesProd(request)){
			urlRedirect = linkR;
			
		}
		
		request.setAttribute("listeCategorieValid", "true");
		request.getRequestDispatcher(urlRedirect).forward(request, response);
	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
