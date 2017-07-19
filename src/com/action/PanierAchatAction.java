package com.action;

//import java.security.KeyStore.Entry;
import java.util.Enumeration;
import java.util.Hashtable;

public class PanierAchatAction {
	 private static Hashtable panier = new Hashtable();
	 
	 public static void ajouterProduitPanier(String codeProduit){
		int quantite = 1;
		Enumeration clesProduits = panier.keys();
		
		while(clesProduits.hasMoreElements()){
			if (clesProduits.nextElement().equals(codeProduit)){		
				quantite = (int) panier.get(codeProduit);
				quantite++;
			}
		}
		
		panier.put(codeProduit, quantite);
	}
	
	public static void retirerProduitPanier(String codeProduit){
		Enumeration clesProduits = panier.keys();
		
		while(clesProduits.hasMoreElements()){
			if (clesProduits.nextElement().equals(codeProduit)){		
				panier.remove(codeProduit);
			}
		}
	}
}
