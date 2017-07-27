package com.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.entities.PhotoProduit;
import com.entities.Rating;
import com.manager.PhotoProduitManager;
import com.manager.RatingManager;

public class RatingAction {

	public static boolean afficherRatingProd(HttpServletRequest request) {

		ArrayList<Rating> rating = RatingManager.getAll();

		request.setAttribute("listRatingProd", rating);

		return (rating != null ? true : false);
	}
	
	public static boolean afficherRatingWithIdProd(HttpServletRequest request,int id) {

		ArrayList<Rating> rating = RatingManager.getByIdProd(id);

		request.setAttribute("listRatingProd", rating);

		return (rating != null ? true : false);
	}
	
	public static boolean afficherRatingWithIdUtil(HttpServletRequest request,int id) {

		ArrayList<Rating> rating = RatingManager.getByIdUtil(id);

		request.setAttribute("listRatingProd", rating);

		return (rating != null ? true : false);
	}
	
	public static boolean afficherRatingWithIdUtilNIdProd(HttpServletRequest request,int idUtil, int idProd) {

		ArrayList<Rating> rating = RatingManager.getByIdUtilNIdProd(idUtil, idProd);

		request.setAttribute("listRatingUtilProd", rating);

		return (rating != null ? true : false);
	}
	
	public static boolean insertRating(Rating rating) {
		boolean retour = false;

		if (RatingManager.insert(rating)) {
			retour = true;
		}

		return retour;
	}

	public static boolean updateRating(Rating rating) {
		boolean retour = false;

		if (RatingManager.update(rating)) {
			retour = true;
		}

		return retour;
	}

	public static boolean deleteRating(int id_util,int id_prod){
		boolean retour= false;		
		
		if(RatingManager.delete(id_prod, id_util))
			retour =true;
		
		return retour;
	}
}
