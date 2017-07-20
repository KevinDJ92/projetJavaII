package com.manager;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

import com.entities.LigneCommande;
import com.entities.Produit;

public class ManagerLigneCommande {
public  static void  addProduit(Integer quantite, Produit produit,HashMap<Integer,LigneCommande> monPanier){
		
		LigneCommande ligneCommande;
		Integer idProduit=produit.getId();
		
		if (monPanier.containsKey(idProduit)) {
			ligneCommande=monPanier.get(idProduit);
			Integer nouvellequantite=ligneCommande.getQuantite()+quantite;
			ligneCommande.setQuantite(nouvellequantite);
			monPanier.put(idProduit, ligneCommande);
		}
		else{
			ligneCommande = new LigneCommande();
			ligneCommande.setProduit(produit);;
			ligneCommande.setQuantite(quantite);
			monPanier.put(idProduit, ligneCommande);
		}
		
	}
	
	public static void removeProduit(Produit produit, Integer quantite, HashMap<Integer, LigneCommande> monPanier){
		
		LigneCommande ligneCommande;
		Integer idProduit=produit.getId();
		if (monPanier.containsKey(idProduit)) {
			
			ligneCommande=monPanier.get(idProduit);
			
			Integer soustraction=ligneCommande.getQuantite()-quantite;
			if (soustraction>0) {
				ligneCommande.setQuantite(soustraction);
				monPanier.put(idProduit, ligneCommande);
			}
			else{
				
				monPanier.remove(idProduit);
			}
			
		}
	}
	
	public static Integer getQuantite(Produit produit,Hashtable<Integer, LigneCommande> monPanier){
		
		Integer quantite=0;
		Integer idProduit=produit.getId();
		if (monPanier.containsKey(idProduit)) {
			
			LigneCommande ligneCommande=monPanier.get(idProduit);
			quantite=ligneCommande.getQuantite();
		}
		return quantite;
	}
	
	public static Integer getNombreArticle(HashMap<Integer, LigneCommande> monPanier){
		
		Integer nbrArticle=0;
		
		if (monPanier.size()>0) {
			
			Set listeIdProduit = monPanier.keySet();
			
			Iterator it = listeIdProduit.iterator();
			
			LigneCommande ligneCommandet;
			
			while (it.hasNext()) {
				ligneCommandet=monPanier.get(it.next());
				nbrArticle+=ligneCommandet.getQuantite();
			}
		}
		
		return nbrArticle;
	}
}
