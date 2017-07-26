package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.ProduitAction;
import com.entities.Produit;
import com.google.gson.Gson;
import com.utils.Constante;

@WebServlet("/afficheProduitAjax")
public class AfficheProduitAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AfficheProduitAjax() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String categorie = request.getParameter("categorie");
		String prixMin = request.getParameter("prixMin");
		String prixMax = request.getParameter("prixMax");
		String nomProd = request.getParameter("nomProd");
		String idProd = request.getParameter("idProd");
		
		if(categorie == null && prixMin == null 
				&& prixMax == null && nomProd == null &&
				idProd == null){
		//	System.out.println(urlRedirect);
			
			if(ProduitAction.afficherProduit(request)){
				
				
			}
		} else{
			if(prixMin == null 
					&& prixMax == null && nomProd == null &&
					idProd == null && categorie != null){
				if(ProduitAction.afficherProduitParCategorie(request, categorie)){
					
					
			
				}
			}
			
			else if(categorie == null && prixMax == null &&
					nomProd == null && idProd == null){
				if(ProduitAction.afficherProduitParPrix(request, Double.parseDouble(prixMin))){
					
				}
			}
			
			else if(categorie == null 
					&& prixMin == null && prixMax == null &&
					idProd == null){
				if(ProduitAction.afficherProduitParNomPourRecherche(request, nomProd)){
					
					Gson gson = new Gson();
//					gson.toJson((ArrayList<Produit>)request.getAttribute("listeProd"));
//					System.out.println(gson.toJson((ArrayList<Produit>)request.getAttribute("listeProd")));
					//System.out.println("test");
					//System.out.println(gson.toString());
					response.setContentType("application/json");
					response.setCharacterEncoding("UTF-8");
					
					try(PrintWriter out = response.getWriter()){
						out.print(gson.toJson((ArrayList<Produit>)request.getAttribute("listeProd")));
						
						out.flush();
						
						out.close();
					}
				}
			}
			
			else if(prixMin == null && prixMax == null &&
					idProd == null){
				if(ProduitAction.afficherProduitParNomEtCat(request, nomProd,categorie)){
					
					Gson gson = new Gson();
//					gson.toJson((ArrayList<Produit>)request.getAttribute("listeProd"));
//					System.out.println(gson.toJson((ArrayList<Produit>)request.getAttribute("listeProd")));
					//System.out.println("test");
					//System.out.println(gson.toString());
					response.setContentType("application/json");
					response.setCharacterEncoding("UTF-8");
					
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
					
					
				}
			}
			
			else if(categorie == null && nomProd == null){
				if(ProduitAction.afficherProduitPrixMinMax(request, Double.parseDouble(prixMin), Double.parseDouble(prixMax))){
					
				}
			}
		}
		//pour afficher les image des produits trouver
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
