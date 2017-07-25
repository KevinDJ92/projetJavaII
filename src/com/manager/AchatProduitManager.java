package com.manager;

import java.sql.SQLException;
import java.util.ArrayList;

import com.entities.Achat;
import com.entities.Produit;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.service.ConnexionBD;

public class AchatProduitManager {
	private static String tableName = "achat";
	private static String tableName2 = "produits";
	
	private static String tableListAchat[] = new String[]{"id_achat", "id_util", "id_prod", "confirmation_num", "date_achat", "adresse_exped", "suivi","qte"};
	private static String tableListProduit[] = new String[]{"id_prod", "nom_prod", "detail_prod", "prix_prod", "etat_prod" ,"categorie_prod", "qte_stock"};
	
	private static String queryAchatProduitWhereIdUtilisateur  = "SELECT * FROM " + tableName + " INNER JOIN " + tableName2 
		+ " ON " + tableName +"." + tableListAchat[2] 
			+ " = " + tableName2 + "." + tableListProduit[2] 
				+ " WHERE id_util = ?";
	
	public static ArrayList<Produit> getProduitAchater(int id_util) {
		ArrayList<Produit> retour = null;

		try {
			PreparedStatement ps =  (PreparedStatement) ConnexionBD.getConnection().prepareStatement(queryAchatProduitWhereIdUtilisateur);
			ResultSet result = (ResultSet) ps.executeQuery();
			ps.setInt(1, id_util);
			
			if (result.isBeforeFirst()) {
				
				retour = new ArrayList<>();

				while (result.next()) {
					Produit prod = new Produit();
			
					prod.setId(result.getInt(tableListProduit[0]));
					prod.setNom(result.getString(tableListProduit[1]));
					prod.setCategorie(result.getString(tableListProduit[2]));
					prod.setDetail(result.getString(tableListProduit[3]));
					prod.setEtat(result.getString(tableListProduit[4]));
					prod.setPrix(result.getDouble(tableListProduit[5]));
					prod.setQte(result.getInt(tableListProduit[6]));
				
					retour.add(prod);
							
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ConnexionBD.closeConnection();
		
		return retour;
	}
}
