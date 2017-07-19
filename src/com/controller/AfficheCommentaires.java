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

/**
 * Servlet implementation class AfficheCommentaires
 */
@WebServlet("/AfficheCommentaires")
public class AfficheCommentaires extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficheCommentaires() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String urlRedirect = Constante.cefErrorPage;
		String linkR = (String)request.getAttribute("link");

		
		
		if(linkR == null){
			linkR = "index.jsp";
		}

		String idProd = request.getParameter("idProd");
		String idUtil = request.getParameter("idUtil");
		
		
			if(idProd == null && idUtil == null){
				if(RatingAction.afficherRatingProd(request)){
					urlRedirect = linkR;
					
				}
			}else{
				if(idProd !=null && idUtil==null){
					if(RatingAction.afficherRatingWithIdProd(request, Integer.parseInt(idProd))){
						urlRedirect = linkR;
						request.setAttribute("listeRateValid", "true");
						request.getRequestDispatcher(urlRedirect).forward(request, response);
						
					}
				}
				if(idProd ==null && idUtil!=null){
					if(RatingAction.afficherRatingWithIdUtil(request, Integer.parseInt(idProd))){
						urlRedirect = linkR;
						request.setAttribute("listeRateValid", "true");
						request.getRequestDispatcher(urlRedirect).forward(request, response);
					}
				}
			}
			
			
		
		
		
		//pour afficher les image des produits trouver
//		if(urlRedirect!= Constante.cefErrorPage){
////			Array
//			
//				PhotoAction.afficherPhotoProd(request);
//				RatingAction.afficherRatingProd(request);
//			
//		}
			//listeRateValid
			
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public static boolean RecupererAllRating(HttpServletRequest request){
		request.setAttribute("listeRateValid", "true");
		return RatingAction.afficherRatingProd(request);
	}
}
