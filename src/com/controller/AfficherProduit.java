package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.PhotoAction;
import com.action.ProduitAction;
import com.action.RatingAction;
import com.entities.PhotoProduit;
import com.entities.Produit;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.research.ws.wadl.Request;
import com.utils.Constante;


@WebServlet("/AfficherProduit")
public class AfficherProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public AfficherProduit() {
        super();
        System.out.println("test construct");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String urlRedirect = Constante.cefErrorPage;
		String urlRedirect ="";
		
		String linkR = (String)request.getAttribute("link");
		
		if(linkR == null){
			linkR = "produits.jsp";
			
		}
		
		String categorie = request.getParameter("categorie");
		String prixMin = request.getParameter("prixMin");
		String prixMax = request.getParameter("prixMax");
		String nomProd = request.getParameter("nomProd");
		String idProd = request.getParameter("idProd");
		
		if(categorie == null && prixMin == null 
				&& prixMax == null && nomProd == null &&
				idProd == null){
//			System.out.println(urlRedirect);
			
			if(ProduitAction.afficherProduit(request)){
				urlRedirect = linkR;
				
				
				
				
			}
		}else{

			if(prixMin == null 
					&& prixMax == null && nomProd == null &&
					idProd == null && categorie != null){
				if(ProduitAction.afficherProduitParCategorie(request, categorie)){
					urlRedirect = linkR;
					
					
					
					
				}

				
				
			}
			
			else if(categorie == null && prixMax == null &&
					nomProd == null && idProd == null){
				if(ProduitAction.afficherProduitParPrix(request, Double.parseDouble(prixMin))){
					urlRedirect = linkR;
					System.out.println(urlRedirect);
				}
			}
			
			else if(categorie == null 
					&& prixMin == null && prixMax == null &&
					idProd == null){
				if(ProduitAction.afficherProduitParNom(request, nomProd)){
					urlRedirect = linkR;
					Gson gson = new Gson();
//					gson.toJson((ArrayList<Produit>)request.getAttribute("listeProd"));
//					System.out.println(gson.toJson((ArrayList<Produit>)request.getAttribute("listeProd")));
					//System.out.println("test");
					//System.out.println(gson.toString());
					response.setContentType("application/json");
					response.setCharacterEncoding("UTF-8");
					System.out.println(gson.toJson((ArrayList<Produit>)request.getAttribute("listeProd")));
					try(PrintWriter out = response.getWriter()){
						out.print(gson.toJson((ArrayList<Produit>)request.getAttribute("listeProd")));
						
						out.flush();
						
						out.close();
					}
					
					
					
				}
			}
			
			else if(categorie == null 
					&& prixMin == null && prixMax == null &&
					nomProd == null){
				if(ProduitAction.afficherProduitParId(request, Integer.parseInt(idProd))){
					urlRedirect = linkR;
					
				}
			}
			
			else if(categorie == null && nomProd == null){
				if(ProduitAction.afficherProduitPrixMinMax(request, Double.parseDouble(prixMin), Double.parseDouble(prixMax))){
					urlRedirect =linkR;
				}
			}
		}
		
		//pour afficher les image des produits trouver
		if(urlRedirect!= Constante.cefErrorPage){			
				//PhotoAction.afficherPhotoProd(request);
//				RatingAction.afficherRatingProd(request);
			
		}
		request.setAttribute("listeProdValid", "true");
		
		request.getRequestDispatcher(urlRedirect).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public static boolean RecupererAllProd(HttpServletRequest request){
		request.setAttribute("listeProdValid", "true");
		return ProduitAction.afficherProduit(request);
	}

}
