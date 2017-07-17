package com.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.entities.Produit;
import com.entities.Utilisateur;
import com.manager.ProduitManager;
import com.manager.UtilisateursManager;

public class UtilisateurAction {
	public static boolean afficherUtilisateur(HttpServletRequest request) {
		boolean retour = false;

		ArrayList<Utilisateur> mesUtil = UtilisateursManager.getAll();

		request.setAttribute("listeUtil", mesUtil);

		return (mesUtil != null ? true : false);
	}
	
	public static boolean afficherUtilisateurParNom(HttpServletRequest request) {
		boolean retour = false;

		ArrayList<Utilisateur> mesUtil = UtilisateursManager.getAll();

		request.setAttribute("listeUtil", mesUtil);

		return (mesUtil != null ? true : false);
	}
	
	public static boolean insertUtilisateur(Utilisateur utilToAdd) {
		boolean retour = false;

		if (UtilisateursManager.insert2(utilToAdd)) {
			retour = true;
		}

		return retour;
	}

	public static boolean updateUtilisateur(Utilisateur utilToUpdate) {
		boolean retour = false;

		if (UtilisateursManager.update(utilToUpdate)) {
			retour = true;
		}

		return retour;
	}
	
	public static boolean deleteUtilisateur(int idUtilisateur){
		boolean retour= false;		
		
		if(UtilisateursManager.delete(idUtilisateur))
			retour =true;
		
		return retour;
	}
	
	public static boolean utilisateurExiste (Utilisateur util){	 	
		boolean retour = false ;
	 			if(UtilisateursManager.userExiste(util))
	 				retour =true;
	 	return  retour;
	}
}
