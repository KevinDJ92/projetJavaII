package com.action;


import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import com.entities.Achat;
import com.manager.AchatManager;

public class AchatAction {

	public static boolean ajoutAchat(Achat achat) {
		boolean retour = false;

		if (AchatManager.insert(achat)) {
			retour = true;
		}

		return retour;
	}
	
	public static boolean afficherAchat(HttpServletRequest request) {

		ArrayList<Achat> mesAchats = AchatManager.getAll();
		
		System.out.println("mesAchats" + mesAchats);
		
		request.setAttribute("mesAchats", mesAchats);

		return (mesAchats != null ? true : false);
	}
	
}
