package com.manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.entities.PhotoProduit;
import com.entities.Produit;
import com.service.ConnexionBD;

public class PhotoProduitManager {
	private static String queryGetyAll = "select * from photo_prod";
	private static String queryGetByIdProduit = "select * from photo_prod where id_prod = ?";
	private static String queryInsert = "insert into photo_prod(id_produit,chemin_ftp,extension_pic,alt,is_default) value(?,?,?,?,?)";
	private static String queryUpdate = "update photo_prod set chemin_ftp=?, extension_pic = ?, alt =?,is_default = ? where id_pic = ?";
	private static String querydelete = "delete from produits where id_prod = ?";

	public static ArrayList<PhotoProduit> getAll() {
		ArrayList<PhotoProduit> retour = null;

		try {
			PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(queryGetyAll);

			ResultSet result = ps.executeQuery();

			if (result.isBeforeFirst()) {
				
				retour = new ArrayList<>();

				while (result.next()) {
					PhotoProduit photo = new PhotoProduit();
					photo.setIdPic(result.getInt("id_pic"));
					photo.setIdProd(result.getInt("id_produit"));
					photo.setCheminFtp(result.getString("chemin_ftp"));
					photo.setExtensionPic(result.getString("extension_pic"));
					photo.setAlt(result.getString("alt"));
					photo.setIsDefault(result.getInt("is_default"));

					retour.add(photo);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ConnexionBD.closeConnection();
		
		return retour;
	}
	
	public static ArrayList<PhotoProduit> getByIdProduit(int idProd) {
		ArrayList<PhotoProduit> retour = null;

		try {
			PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(queryGetByIdProduit);
			
			ps.setInt(1, idProd);
			ResultSet result = ps.executeQuery();

			if (result.isBeforeFirst()) {
				
				retour = new ArrayList<>();

				while (result.next()) {
					PhotoProduit photo = new PhotoProduit();
					photo.setIdPic(result.getInt("id_pic"));
					photo.setIdProd(result.getInt("id_produit"));
					photo.setCheminFtp(result.getString("chemin_ftp"));
					photo.setExtensionPic(result.getString("extension_pic"));
					photo.setAlt(result.getString("alt"));
					photo.setIsDefault(result.getInt("is_default"));

					retour.add(photo);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ConnexionBD.closeConnection();
		
		return retour;
	}
	
	
	//INSERTION DANS LA TABLE PRODUIT
	
		public static boolean insert(PhotoProduit photo){
			boolean retour = false;
			int nbLigne = 0;
			PreparedStatement ps;
			
			try {
				ps = ConnexionBD.getConnection().prepareStatement(queryInsert);
				
				ps.setInt(1,photo.getIdProd());
				ps.setString(2,photo.getCheminFtp());
				ps.setString(3,photo.getExtensionPic());
				ps.setString(4,photo.getAlt());
				ps.setInt(5,photo.getIsDefault());
				
				nbLigne = ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
//			System.out.println("nb ligne " + nbLigne);
			if(nbLigne >0 )
				retour = true;		
			ConnexionBD.closeConnection();
			return retour;
		}

		
		//UPDATE
		
		public static boolean update(PhotoProduit photo){
			boolean retour = false;
			int nbLigne = 0;
			PreparedStatement ps;
			try {
				ps = ConnexionBD.getConnection().prepareStatement(queryUpdate);
				
				ps.setString(1,photo.getCheminFtp());
				ps.setString(2,photo.getExtensionPic());
				ps.setString(3,photo.getAlt());
				ps.setInt(4,photo.getIsDefault());
				ps.setInt(5,photo.getIdPic());
				
				
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
		
		//SUPPRIMER UN PRODUIT 
		
		public static boolean delete(int idProd){
			boolean retour = false;
			int nbLigne = 0;
			PreparedStatement ps;
			try {
				ps = ConnexionBD.getConnection().prepareStatement(querydelete);
				ps.setInt(1,idProd);
				
				
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
