package com.manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.entities.Produit;
import com.entities.Rating;
import com.service.ConnexionBD;

public class RatingManager {

	private static String queryGetyAll = "select * from rating";
	private static String queryGetByIdUtil = "select * from rating where id_util like ?";
	private static String queryGetByIdProd = "select * from rating where id_prod like ?";
	private static String queryGetByDate = "select * from rating where date_ajout like ?";
	private static String queryGetByDateBetween = "select * from rating where date_ajout between ? and ?";
	private static String queryInsert = "insert into rating(id_util,id_prod,note,commentaire,date_ajout) value(?,?,?,?,?)";
	private static String queryUpdate = "update rating set note =?,commentaire =?,date_ajout =? where id_util = ? and id_prod = ?";
	private static String querydelete = "delete from rating where id_util =? and id_prod =?";
	
	
	public static ArrayList<Rating> getAll() {
		ArrayList<Rating> retour = null;

		try {
			PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(queryGetyAll);

			ResultSet result = ps.executeQuery();

			if (result.isBeforeFirst()) {
				
				retour = new ArrayList<>();

				while (result.next()) {
					Rating rating = new Rating();
					rating.setIdProduit(result.getInt("id_prod"));
					rating.setIdUtil(result.getInt("id_util"));
					rating.setNote(result.getInt("note"));
					rating.setCommentaire(result.getString("commentaire"));
					rating.setDate(result.getDate("date_ajout"));
					//result.getDa

					retour.add(rating);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ConnexionBD.closeConnection();
		
		return retour;
	}
	

	
	public static ArrayList<Rating> getByIdUtil(int idUtil) {
		ArrayList<Rating> retour = null;

		try {
			PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(queryGetByIdUtil);
			ps.setInt(1, idUtil);
			ResultSet result = ps.executeQuery();

			if (result.isBeforeFirst()) {
				
				retour = new ArrayList<>();

				while (result.next()) {
					Rating rating = new Rating();
					rating.setIdProduit(result.getInt("id_prod"));
					rating.setIdUtil(result.getInt("id_util"));
					rating.setNote(result.getInt("note"));
					rating.setCommentaire(result.getString("commentaire"));
					rating.setDate(result.getDate("date_ajout"));

					retour.add(rating);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ConnexionBD.closeConnection();
		
		return retour;
	}
	
	
	public static ArrayList<Rating> getByIdProd(int idProd) {
		ArrayList<Rating> retour = null;

		try {
			PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(queryGetByIdProd);
			ps.setInt(1, idProd);
			ResultSet result = ps.executeQuery();

			if (result.isBeforeFirst()) {
				
				retour = new ArrayList<>();

				while (result.next()) {
					Rating rating = new Rating();
					rating.setIdProduit(result.getInt("id_prod"));
					rating.setIdUtil(result.getInt("id_util"));
					rating.setNote(result.getInt("note"));
					rating.setCommentaire(result.getString("commentaire"));
					rating.setDate(result.getDate("date_ajout"));

					retour.add(rating);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ConnexionBD.closeConnection();
		
		return retour;
	}
	
	
	public static ArrayList<Rating> getByDate(java.sql.Date date) {
		ArrayList<Rating> retour = null;

		try {
			PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(queryGetByDate);
			ps.setDate(1, date);
			ResultSet result = ps.executeQuery();

			if (result.isBeforeFirst()) {
				
				retour = new ArrayList<>();

				while (result.next()) {
					Rating rating = new Rating();
					rating.setIdProduit(result.getInt("id_prod"));
					rating.setIdUtil(result.getInt("id_util"));
					rating.setNote(result.getInt("note"));
					rating.setCommentaire(result.getString("commentaire"));
					rating.setDate(result.getDate("date_ajout"));

					retour.add(rating);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ConnexionBD.closeConnection();
		
		return retour;
	}
	
	//date_ajout between ? and ?";
	public static ArrayList<Rating> getByDateBetween(java.sql.Date date1, java.sql.Date date2) {
		ArrayList<Rating> retour = null;

		try {
			PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(queryGetByDateBetween);
			ps.setDate(1, date1);
			ps.setDate(2, date2);
			ResultSet result = ps.executeQuery();

			if (result.isBeforeFirst()) {
				
				retour = new ArrayList<>();

				while (result.next()) {
					Rating rating = new Rating();
					rating.setIdProduit(result.getInt("id_prod"));
					rating.setIdUtil(result.getInt("id_util"));
					rating.setNote(result.getInt("note"));
					rating.setCommentaire(result.getString("commentaire"));
					rating.setDate(result.getDate("date_ajout"));

					retour.add(rating);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ConnexionBD.closeConnection();
		
		return retour;
	}
	
	
	//INSERTION DANS LA TABLE PRODUIT
	
		public static boolean insert(Rating rating){
			boolean retour = false;
			int nbLigne = 0;
			PreparedStatement ps;
			//insert into rating(id_util,id_prod,note,commentaire,date_ajout
			try {
				ps = ConnexionBD.getConnection().prepareStatement(queryInsert);
				ps.setInt(1,rating.getIdUtil());
				ps.setInt(2,rating.getIdProduit());
				ps.setInt(3,rating.getNote());
				ps.setString(4,rating.getCommentaire());
				ps.setDate(5,(java.sql.Date)rating.getDate());
				
				nbLigne = ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(nbLigne >0 )
				retour = true;		
			ConnexionBD.closeConnection();
			return retour;
		}
		
		//UPDATE 
		
		public static boolean update(Rating rating){
			boolean retour = false;
			int nbLigne = 0;
			PreparedStatement ps;
			try {
				ps = ConnexionBD.getConnection().prepareStatement(queryUpdate);
				//note =?,commentaire =?,date_ajout =? where id_util = ? and id_prod = ?
				ps.setInt(1,rating.getNote());
				ps.setString(2,rating.getCommentaire());
				ps.setDate(3,(java.sql.Date)rating.getDate());
				ps.setInt(4,rating.getIdUtil());
				ps.setInt(5,rating.getIdProduit());
				
				
				nbLigne = ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			if(nbLigne >0 )
				retour = true;		
			ConnexionBD.closeConnection();
			return retour;
		}
	
		//Delete table
		
		public static boolean delete(int prodId, int utilId){
			boolean retour = false;
			int nbLigne = 0;
			PreparedStatement ps;
			try {
				
				ps = ConnexionBD.getConnection().prepareStatement(querydelete);
				ps.setInt(1,utilId);
				ps.setInt(2,prodId);
				
				
				nbLigne = ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			if(nbLigne >0 )
				retour = true;		
			ConnexionBD.closeConnection();
			return retour;
		}
}
