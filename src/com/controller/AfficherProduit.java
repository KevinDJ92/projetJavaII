package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.ProduitAction;
import com.utils.Constante;

/**
 * Servlet implementation class AfficherProduit
 */
@WebServlet("/AfficherProduit")
public class AfficherProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficherProduit() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String urlRedirect = Constante.cefErrorPage;
		String categorie = request.getParameter("categorie");
		String prixMin = request.getParameter("prixMin");
		String prixMax = request.getParameter("prixMax");
		String nomProd = request.getParameter("nomProd");
		String idProd = request.getParameter("idProd");
		
		if(categorie == null && prixMin == null 
				&& prixMax == null && nomProd == null &&
				idProd == null){
			
			if(ProduitAction.afficherProduit(request)){
				urlRedirect = "Test.jsp";
			}
		}else{
			if(prixMin == null 
					&& prixMax == null && nomProd == null &&
					idProd == null){
				if(ProduitAction.afficherProduitParCategorie(request, categorie)){
					urlRedirect = "Test.jsp";
				}
				
			}
			
			else if(categorie == null && prixMax == null &&
					nomProd == null && idProd == null){
				if(ProduitAction.afficherProduitParPrix(request, Double.parseDouble(prixMin))){
					urlRedirect = "Test.jsp";
				}
			}
			
			else if(categorie == null 
					&& prixMin == null && prixMax == null &&
					idProd == null){
				if(ProduitAction.afficherProduitParNom(request, nomProd)){
					urlRedirect = "Test.jsp";
				}
			}
			
			else if(categorie == null 
					&& prixMin == null && prixMax == null &&
					nomProd == null){
				if(ProduitAction.afficherProduitParId(request, Integer.parseInt(idProd))){
					urlRedirect = "Test.jsp";
				}
			}
			
			else if(categorie == null && nomProd == null){
				if(ProduitAction.afficherProduitPrixMinMax(request, Double.parseDouble(prixMin), Double.parseDouble(prixMax))){
					urlRedirect = "Test.jsp";
				}
			}
		}
		
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
