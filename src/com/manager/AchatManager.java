package com.manager;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import com.entities.Achat;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import com.service.ConnexionBD;
import com.enumeration.ACHAT_TABLE;

public class AchatManager {
	private static String tableName = "achat";
	private static String tableList[] = new String[]{"id_achat", "id_util", "id_prod", "confirmation_num", "date_achat", "adresse_exped", "suivi","qte"};

	//private static String queryInsert = "INSERT INTO " +  tableName + " ("+tableList[1]+tableList[2] + tableList[3] + tableList[4] + tableList[5] + tableList[6] + tableList[7]+") VALUE(?,?,?,?,?,?,?)";
	private static String queryInsert = "insert into achat(id_util,id_prod,confirmation_num,adresse_exped,suivi,qte) value(?,?,?,?,?,?)";
	
	private static String queryUpdate = "UPDATE"  +  tableName + "SET " + tableList[3] + "= ?, " + tableList[4] + "= ?, " 
										 + tableList[5] + " = ?, " + tableList[6] + "= ?";
	private static String queryDelete = "DELETE FROM " + tableName + " WHERE " + tableList[0] + " = ?";

	
	private static String queryGetyAll = "SELECT * FROM " + tableName;
	private static String queryGetById = "SELECT * FROM " + tableName + " WHERE " + tableList[0] + " = ?";
	private static String queryGetBy = "SELECT * FROM " + tableName + " WHERE ? = ?";
	
	
	public static boolean insert(Achat table){
		boolean retour = false;
		int nbLigne = 0;
		PreparedStatement ps;
		
		//"id_achat", "id_util", "id_prod", "confirmation_num", "date_achat", "adresse_exped", "suivi","qte"
		//"INSERT INTO " +  tableName + " ("+tableList[1]+tableList[2] + tableList[3] + tableList[4] + tableList[5] + tableList[6] + tableList[7]+") VALUE(?,?,?,?,?,?,?)"
		try {
			ps = (PreparedStatement) ConnexionBD.getConnection().prepareStatement(queryInsert);
			
			
			ps.setInt(1, table.getIdUtil());
			ps.setInt(2, table.getIdProd());
			ps.setString(3, table.getConfirmNum());
			
			ps.setString(4, table.getAdresseExp());
			ps.setString(5, table.getSuivi());
			ps.setInt(6, table.getQte());
			
			nbLigne = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(nbLigne > 0)
			retour = true;	
	
		ConnexionBD.closeConnection();
		return retour;
	}
	
	public static boolean insert2(Achat table){
		boolean retour = false;
		ResultSet idRetour = null;
		PreparedStatement ps;
		int nbLigne = 0;
		try {
			ps = (PreparedStatement) ConnexionBD.getConnection().prepareStatement(queryInsert, Statement.RETURN_GENERATED_KEYS);
			
			ps.setInt(1, table.getIdAchat());
			ps.setInt(2, table.getIdUtil());
			ps.setInt(3, table.getIdProd());
			ps.setString(4, table.getConfirmNum());
			ps.setDate(5, (Date) table.getDateAchat());
			ps.setString(6, table.getAdresseExp());
			ps.setString(7, table.getSuivi());
			
			nbLigne = ps.executeUpdate();
			idRetour = (ResultSet) ps.getGeneratedKeys();
			idRetour.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(nbLigne >0 )
			retour = true;	
		
		ConnexionBD.closeConnection();
		return retour;
	}
		public static boolean update(Achat table){
			boolean retour = false;
			int nbLigne = 0;
			PreparedStatement ps;
			try {
				ps = (PreparedStatement) ConnexionBD.getConnection().prepareStatement(queryUpdate);
				
				ps.setInt(1, table.getIdAchat());
				ps.setInt(2, table.getIdUtil());
				ps.setInt(3, table.getIdProd());
				ps.setString(4, table.getConfirmNum());
				ps.setDate(5, (Date) table.getDateAchat());
				ps.setString(6, table.getAdresseExp());
				ps.setString(7, table.getSuivi());
				
				nbLigne = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
			if(nbLigne > 0 )
				retour = true;		
			ConnexionBD.closeConnection();
			return retour;
		}
		
	public static boolean delete(int utilId){
		boolean retour = false;
		int nbLigne = 0;
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) ConnexionBD.getConnection().prepareStatement(queryDelete);
			ps.setInt(1, utilId);
			
			nbLigne = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(nbLigne > 0)
			retour = true;		
		ConnexionBD.closeConnection();
		return retour;
	}
	
	public enum TABLE {
	    CONFIM_NUM, DATE_ACHAT, ADRESSE_EXP, SUIVI
	}
	
	public static ArrayList<Achat> getAll() {
		ArrayList<Achat> retour = null;

		try {
			PreparedStatement ps =  (PreparedStatement) ConnexionBD.getConnection().prepareStatement(queryGetyAll);
			ResultSet result = (ResultSet) ps.executeQuery();

			if (result.isBeforeFirst()) {
				
				retour = new ArrayList<>();

				while (result.next()) {
					Achat table = new Achat();
					table.setIdAchat(result.getInt(tableList[0]));
					table.setIdUtil(result.getInt(tableList[1]));
					table.setIdProd(result.getInt(tableList[2]));
					table.setConfirmNum(result.getString(tableList[3]));
					table.setDateAchat(result.getDate(tableList[4]));
					table.setAdresseExp(result.getString(tableList[5]));
					table.setSuivi(result.getString(tableList[6]));
					retour.add(table);
							
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ConnexionBD.closeConnection();
		
		return retour;
	}
	
	public static Achat getById(int id) {
		Achat retour = null;
		
		try {
			PreparedStatement ps = (PreparedStatement) ConnexionBD.getConnection().prepareStatement(queryGetById);
			ps.setInt(1, id);
			
			ResultSet result = (ResultSet) ps.executeQuery();

			if (result.isBeforeFirst()) {
				
				retour = new Achat();	
				
				while (result.next()) {		
					retour.setIdAchat(result.getInt(tableList[0]));
					retour.setIdUtil(result.getInt(tableList[1]));
					retour.setIdProd(result.getInt(tableList[2]));
					retour.setConfirmNum(result.getString(tableList[3]));
					retour.setDateAchat(result.getDate(tableList[4]));
					retour.setAdresseExp(result.getString(tableList[5]));
					retour.setSuivi(result.getString(tableList[6]));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConnexionBD.closeConnection();
		return retour;
	}
	
	public static Achat getBy(ACHAT_TABLE table, String nom){
		
		String tableName = null;
		Achat retour = null;
		tableName = getTableName(table);
		
		try {
			
			PreparedStatement ps = (PreparedStatement) ConnexionBD.getConnection().prepareStatement(queryGetBy);
			ps.setString(1, tableName);
			ps.setString(2, nom);
			
			ResultSet result = (ResultSet) ps.executeQuery();

			if (result.isBeforeFirst()) {
				retour = new Achat();	
				
				while (result.next()) {			
					retour.setIdAchat(result.getInt(tableList[0]));
					retour.setIdUtil(result.getInt(tableList[1]));
					retour.setIdProd(result.getInt(tableList[2]));
					retour.setConfirmNum(result.getString(tableList[3]));
					retour.setDateAchat(result.getDate(tableList[4]));
					retour.setAdresseExp(result.getString(tableList[5]));
					retour.setSuivi(result.getString(tableList[6]));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConnexionBD.closeConnection();
		return retour;
	}
	
	public static String getTableName(ACHAT_TABLE table){
		String tableName = null;
		
		switch(table){
		case CONFIM_NUM:
			tableName = tableList[3];
			break;
		case DATE_ACHAT:
			tableName = tableList[4];
			break;
		case ADRESSE_EXP:
			tableName = tableList[5];
			break;
		case SUIVI:
			tableName = tableList[6];
			break;
		}

		return tableName;
	}
}
