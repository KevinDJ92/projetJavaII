package com.action;

import java.util.Enumeration;
import java.util.Hashtable;

public class PanierAchatAction {
//	int nbProduit = 0;
	
	public static String ajouterProduitPanier(String codeProduit, int quantite){
		Hashtable panier = new Hashtable();
		panier.put(codeProduit, quantite);
		return "";
	}

//	String quantite = (String)panier.get(codeProduit);
//
//	panier.remove(codeProduit);
//
//	// list des clefs
//	Enumeration clesProduits = panier.keys();
//
//	// hasMoreElements() et nextElement()
//
//	while( clesProduits.hasMoreElements() ) {
//		codeProduit = (String) clesProduits.nextElement();
//		quantite    = (String) panier.get(codeProduit);
//		out.println( "Produit choisi:" + codeProduit +
//				  "Quantite:"       + quantite);

}
