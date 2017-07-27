package com.action;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import com.entities.Achat;
import com.entities.AchatProduit;
import com.manager.AchatManager;
import com.manager.AchatProduitManager;

public class AchatAction {

	public static boolean ajoutAchat(Achat achat) {
		boolean retour = false;

		if (AchatManager.insert(achat)) {
			retour = true;
		}

		return retour;
	}
	
	public static boolean afficherAchat(HttpServletRequest request, int id) {

		ArrayList<AchatProduit> mesAchats =  AchatProduitManager.getProduitAchater(id);
		
		request.setAttribute("mesAchats", mesAchats);

		return (mesAchats != null ? true : false);
	}
	
}
