package com.action;


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
}
