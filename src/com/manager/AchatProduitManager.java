package com.manager;

import java.sql.SQLException;
import java.util.ArrayList;

import com.entities.AchatProduit;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.service.ConnexionBD;

public class AchatProduitManager {
	private static String queryAchatProduitWhereIdUtilisateur = "SELECT p.id_prod, p.nom_prod, p.prix_prod, p.detail_prod, a.qte, a.date_achat" +
																	" FROM achat a INNER JOIN produits p" +
																	" ON a.id_prod = p.id_prod" +
																	" WHERE a.id_util =  ?";
	
	public static ArrayList<AchatProduit> getProduitAchater(int id_util) {
		ArrayList<AchatProduit> retour = null;

		try {
			PreparedStatement ps =  (PreparedStatement) ConnexionBD.getConnection().prepareStatement(queryAchatProduitWhereIdUtilisateur);
			ps.setInt(1, id_util);

			ResultSet result = (ResultSet) ps.executeQuery();
			
			if (result.isBeforeFirst()) {	
				retour = new ArrayList<>();

				while (result.next()) {
					AchatProduit achatProd = new AchatProduit();
					
					achatProd.setIdAchat(result.getInt("id_prod"));
					achatProd.setNomAchat(result.getString("nom_prod"));
					achatProd.setPrixAchat(result.getString("prix_prod"));
					achatProd.setDetailAchat(result.getString("detail_prod"));
					achatProd.setQuantiteAchat(result.getInt("qte"));
					achatProd.setQuantiteAchat(result.getInt("qte"));
					achatProd.setDateAchat(result.getDate("date_achat"));
			
					retour.add(achatProd);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ConnexionBD.closeConnection();
		
		return retour;
	}
}
