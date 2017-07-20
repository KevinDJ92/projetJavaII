package com.manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.entities.Produit;
import com.service.ConnexionBD;

public class ProduitManager {
	private static String queryGetyAll = "select * from produits";
	private static String queryGetAllCat = "select distinct categorie_prod from produits";
	private static String queryGetByName = "select * from produits where nom_prod like ?";
	private static String queryGetByCategorie = "select * from produits where categorie_prod like ?";
	private static String queryGetByEtat = "select * from produits where etat_prod like ?";
	private static String queryGetById = "select * from produits where id_prod = ?";
	private static String queryGetByPrice = "select * from produits where prix_prod = ?";
	private static String queryGetByPriceBetween = "select * from produits where prix_prod between ? and ?";
	private static String queryInsert = "insert into produits(nom_prod,detail_prod,prix_prod,etat_prod,categorie_prod,qte_stock) value(?,?,?,?,?,?)";
	private static String queryUpdate = "update produits set nom =?,detail_prod = ?,prix_prod = ?,etat_prod = ?,categorie_prod =?,qte_prod =? where id_prod = ?";
	private static String querydelete = "delete from produits where id_prod = ?";

	public static ArrayList<Produit> getAll() {
		ArrayList<Produit> retour = null;

		try {
			PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(queryGetyAll);

			ResultSet result = ps.executeQuery();

			if (result.isBeforeFirst()) {
				
				retour = new ArrayList<>();

				while (result.next()) {
					Produit prod = new Produit();
					prod.setId(result.getInt("id_prod"));
					prod.setNom(result.getString("nom_prod"));
					prod.setCategorie(result.getString("categorie_prod"));
					prod.setDetail(result.getString("detail_prod"));
					prod.setEtat(result.getString("etat_prod"));
					prod.setPrix(result.getDouble("prix_prod"));
					prod.setQte(result.getInt("qte_stock"));

					retour.add(prod);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ConnexionBD.closeConnection();
		
		return retour;
	}

	public static ArrayList<String> getAllCategorie() {
		ArrayList<String> retour = null;

		try {
			PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(queryGetAllCat);

			ResultSet result = ps.executeQuery();

			if (result.isBeforeFirst()) {
				
				retour = new ArrayList<>();

				while (result.next()) {
					retour.add(result.getString("categorie_prod"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ConnexionBD.closeConnection();
		
		return retour;
	}

	public static ArrayList<Produit> getByName(String name) {
		ArrayList<Produit> retour = null;

		try {
			PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(queryGetByName);
			ps.setString(1, name);
			ResultSet result = ps.executeQuery();

			if (result.isBeforeFirst()) {
				
				retour = new ArrayList<>();

				while (result.next()) {
					Produit prod = new Produit();
					prod.setId(result.getInt("id_prod"));
					prod.setNom(result.getString("nom_prod"));
					prod.setCategorie(result.getString("categorie_prod"));
					prod.setDetail(result.getString("detail_prod"));
					prod.setEtat(result.getString("etat_prod"));
					prod.setPrix(result.getDouble("prix_prod"));
					prod.setQte(result.getInt("qte_stock"));

					retour.add(prod);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ConnexionBD.closeConnection();
		
		return retour;
	}
	
	public static ArrayList<Produit> getByCategorie(String categorie) {
		ArrayList<Produit> retour = null;
		
		try {
			PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(queryGetByCategorie);

			ps.setString(1, categorie);
			ResultSet result = ps.executeQuery();

			if (result.isBeforeFirst()) {
				
				retour = new ArrayList<>();

				while (result.next()) {
					Produit prod = new Produit();
					prod.setId(result.getInt("id_prod"));
					prod.setNom(result.getString("nom_prod"));
					prod.setCategorie(result.getString("categorie_prod"));
					prod.setDetail(result.getString("detail_prod"));
					prod.setEtat(result.getString("etat_prod"));
					prod.setPrix(result.getDouble("prix_prod"));
					prod.setQte(result.getInt("qte_stock"));

					retour.add(prod);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ConnexionBD.closeConnection();
		
		return retour;
	}
	
	public static ArrayList<Produit> getByEtat(String etat) {
		ArrayList<Produit> retour = null;

		try {
			PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(queryGetByEtat);

			ps.setString(1, etat);
			ResultSet result = ps.executeQuery();

			if (result.isBeforeFirst()) {
				
				retour = new ArrayList<>();

				while (result.next()) {
					Produit prod = new Produit();
					prod.setId(result.getInt("id_prod"));
					prod.setNom(result.getString("nom_prod"));
					prod.setCategorie(result.getString("categorie_prod"));
					prod.setDetail(result.getString("detail_prod"));
					prod.setEtat(result.getString("etat_prod"));
					prod.setPrix(result.getDouble("prix_prod"));
					prod.setQte(result.getInt("qte_stock"));

					retour.add(prod);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ConnexionBD.closeConnection();
		
		return retour;
	}
	
	public static ArrayList<Produit> getById(int id) {
		ArrayList<Produit> retour = null;

		try {
			PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(queryGetById);

			ps.setInt(1, id);
			ResultSet result = ps.executeQuery();

			if (result.isBeforeFirst()) {
				
				retour = new ArrayList<>();

				while (result.next()) {
					Produit prod = new Produit();
					prod.setId(result.getInt("id_prod"));
					prod.setNom(result.getString("nom_prod"));
					prod.setCategorie(result.getString("categorie_prod"));
					prod.setDetail(result.getString("detail_prod"));
					prod.setEtat(result.getString("etat_prod"));
					prod.setPrix(result.getDouble("prix_prod"));
					prod.setQte(result.getInt("qte_stock"));

					retour.add(prod);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ConnexionBD.closeConnection();
		
		return retour;
	}
	
	public static ArrayList<Produit> getByPrice(double price) {
		ArrayList<Produit> retour = null;

		try {
			PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(queryGetByPrice);

			ps.setDouble(1, price);
			ResultSet result = ps.executeQuery();

			if (result.isBeforeFirst()) {
				
				retour = new ArrayList<>();

				while (result.next()) {
					Produit prod = new Produit();
					prod.setId(result.getInt("id_prod"));
					prod.setNom(result.getString("nom_prod"));
					prod.setCategorie(result.getString("categorie_prod"));
					prod.setDetail(result.getString("detail_prod"));
					prod.setEtat(result.getString("etat_prod"));
					prod.setPrix(result.getDouble("prix_prod"));
					prod.setQte(result.getInt("qte_stock"));

					retour.add(prod);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ConnexionBD.closeConnection();
		
		return retour;
	}
	
	public static ArrayList<Produit> getByPriceBetween(double priceMin, double priceMax) {
		ArrayList<Produit> retour = null;

		try {
			PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(queryGetByPriceBetween);

			ps.setDouble(1, priceMin);
			ps.setDouble(2, priceMax);
			ResultSet result = ps.executeQuery();

			if (result.isBeforeFirst()) {
				
				retour = new ArrayList<>();

				while (result.next()) {
					Produit prod = new Produit();
					prod.setId(result.getInt("id_prod"));
					prod.setNom(result.getString("nom_prod"));
					prod.setCategorie(result.getString("categorie_prod"));
					prod.setDetail(result.getString("detail_prod"));
					prod.setEtat(result.getString("etat_prod"));
					prod.setPrix(result.getDouble("prix_prod"));
					prod.setQte(result.getInt("qte_stock"));

					retour.add(prod);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ConnexionBD.closeConnection();
		
		return retour;
	}
	
	
	
	//INSERTION DANS LA TABLE PRODUIT
	
	public static boolean insert(Produit prod){
		boolean retour = false;
		int nbLigne = 0;
		PreparedStatement ps;
		//nom_prod,detail_prod,prix_prod,etat_prod,categorie_prod,qte_prod;
		try {
			ps = ConnexionBD.getConnection().prepareStatement(queryInsert);
			ps.setString(1,prod.getNom());
			ps.setString(2,prod.getDetail());
			ps.setDouble(3,prod.getPrix());
			ps.setString(4,prod.getEtat());
			ps.setString(5,prod.getCategorie());
			ps.setInt(6,prod.getQte());
			
			nbLigne = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		if(nbLigne >0 )
			retour = true;		
		ConnexionBD.closeConnection();
		return retour;
	}
	
	
	public static boolean insertAndRecupId(Produit prod){
		boolean retour = false;
		ResultSet idRetour = null;
		PreparedStatement ps;
		int nbLigne = 0;
		try {
			ps = ConnexionBD.getConnection().prepareStatement(queryInsert,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,prod.getNom());
			ps.setString(2,prod.getDetail());
			ps.setDouble(3,prod.getPrix());
			ps.setString(4,prod.getEtat());
			ps.setString(5,prod.getCategorie());
			ps.setInt(6,prod.getQte());
			
			nbLigne = ps.executeUpdate();
			idRetour = ps.getGeneratedKeys();
			idRetour.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	
		if(nbLigne >0 )
			retour = true;	
	
		ConnexionBD.closeConnection();
		return retour;
	}
	
	//UPDATE 
	public static boolean update(Produit prod){
		boolean retour = false;
		int nbLigne = 0;
		PreparedStatement ps;
		try {
			ps = ConnexionBD.getConnection().prepareStatement(queryUpdate);
			
			ps.setString(1,prod.getNom());
			ps.setString(2,prod.getDetail());
			ps.setDouble(3,prod.getPrix());
			ps.setString(4,prod.getEtat());
			ps.setString(5,prod.getCategorie());
			ps.setInt(6,prod.getQte());
			ps.setInt(7, prod.getId());
			
			
			nbLigne = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		if(nbLigne >0 )
			retour = true;		
		ConnexionBD.closeConnection();
		return retour;
	}
	
	//SUPPRIMER UN PRODUIT 
	
	public static boolean delete(int prodId){
		boolean retour = false;
		int nbLigne = 0;
		PreparedStatement ps;
		try {
			ps = ConnexionBD.getConnection().prepareStatement(querydelete);
			ps.setInt(1,prodId);
			
			
			nbLigne = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		if(nbLigne >0 )
			retour = true;		
		ConnexionBD.closeConnection();
		return retour;
	}
	
	
}
