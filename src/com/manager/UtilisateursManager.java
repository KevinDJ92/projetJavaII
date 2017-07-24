package com.manager;

import java.sql.SQLException;
import java.util.ArrayList;

import com.entities.Utilisateur;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import com.service.ConnexionBD;
import com.enumeration.UTILISATEUR_TABLE;

public class UtilisateursManager {
	private static String tableList[] = new String[]{"id_ut", "nom", "prenom",  "email", "password", "tel_num", "adresse",
											"code_postal", "secure_q","rep_secure_q","photo_profil"};
	
	private static String queryInsert = "INSERT INTO utilisateurs(nom, prenom, email, password, tel_num, adresse, code_postal, secure_q, rep_secure_q, photo_profil) VALUE(?,?,?,?,?,?,?,?,?,?)";
	private static String queryUpdate = "UPDATE utilisateurs SET nom = ?, prenom = ?, email = ?, password = ?, tel_num = ?, adresse = ?, code_postal = ?, secure_q = ?, rep_secure_q = ?, photo_profil = ?";
	private static String queryDelete = "DELETE FROM utilisateurs WHERE id_ut = ?";
	private static String queryConnexion = "SELECT * FROM utilisateurs WHERE email= ? AND password= ?";
	
	private static String queryGetyAll = "SELECT * FROM utilisateurs";
	private static String queryGetById = "SELECT * FROM utilisateurs WHERE id_ut = ?";
	private static String queryGetByEmail = "SELECT * FROM utilisateurs WHERE email = ?";

	private static String queryGetBy = "SELECT * FROM utilisateurs WHERE ? = ?";
	
	public static boolean insert(Utilisateur utilisateur){
		boolean retour = false;
		int nbLigne = 0;
		PreparedStatement ps;
	
		try {
			ps = (PreparedStatement) ConnexionBD.getConnection().prepareStatement(queryInsert);
			ps.setString(1, utilisateur.getNom());
			ps.setString(2, utilisateur.getPrenom());
			ps.setString(3, utilisateur.getEmail());
			ps.setString(4, utilisateur.getPassword());
			ps.setString(5, utilisateur.getTelNum());
			ps.setString(6, utilisateur.getAdresse());
			ps.setString(7, utilisateur.getCodePostal());
			ps.setString(8, utilisateur.getSecureQ());
			ps.setString(9, utilisateur.getRepSecureQ());
			ps.setString(10, utilisateur.getImgLink());
			nbLigne = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(nbLigne > 0)
			retour = true;	
	
		ConnexionBD.closeConnection();
		return retour;
	}
	
	public static boolean insert2(Utilisateur util){
		boolean retour = false;
		ResultSet idRetour = null;
		PreparedStatement ps;
		int nbLigne = 0;
		try {
			ps = (PreparedStatement) ConnexionBD.getConnection().prepareStatement(queryInsert,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, util.getNom());
			ps.setString(2, util.getPrenom());
			ps.setString(3, util.getEmail());
			ps.setString(4, util.getPassword());
			ps.setString(5, util.getTelNum());
			ps.setString(6, util.getAdresse());
			ps.setString(7, util.getCodePostal());
			ps.setString(8, util.getSecureQ());
			ps.setString(9, util.getRepSecureQ());
			ps.setString(10 ,util.getImgLink());
			
			nbLigne = ps.executeUpdate();
			idRetour = (ResultSet) ps.getGeneratedKeys();
			idRetour.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(nbLigne > 0)
			retour = true;	
		
		ConnexionBD.closeConnection();
		return retour;
	}
		public static boolean update(Utilisateur util){
			boolean retour = false;
			int nbLigne = 0;
			PreparedStatement ps;
			try {
				ps = (PreparedStatement) ConnexionBD.getConnection().prepareStatement(queryUpdate);
				ps.setString(1, util.getNom());
				ps.setString(2, util.getPrenom());
				ps.setString(3, util.getEmail());
				ps.setString(4, util.getPassword());
				ps.setString(5, util.getTelNum());
				ps.setString(6, util.getAdresse());
				ps.setString(7, util.getCodePostal());
				ps.setString(8, util.getSecureQ());
				ps.setString(9, util.getRepSecureQ());
				ps.setString(10, util.getImgLink());
				
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
		
		
	public static boolean userExiste(Utilisateur utilisateurs) {
		boolean retour = false;
		PreparedStatement ps;

		int nbUtilisateurs = 0;
		try {
			ps = (PreparedStatement) ConnexionBD.getConnection().prepareStatement(queryConnexion);
			ps.setString(1, utilisateurs.getEmail());
			ps.setString(2, utilisateurs.getPassword());
			ResultSet result = (ResultSet) ps.executeQuery();
			while (result.next()) {
				nbUtilisateurs++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (nbUtilisateurs > 0)
			retour = true;
		System.out.println(nbUtilisateurs + " je suis dans manageur ");
		ConnexionBD.closeConnection();
		return retour;
	}
	
	public static ArrayList<Utilisateur> getAll() {
		ArrayList<Utilisateur> retour = null;

		try {
			PreparedStatement ps =  (PreparedStatement) ConnexionBD.getConnection().prepareStatement(queryGetyAll);
			ResultSet result = (ResultSet) ps.executeQuery();

			if (result.isBeforeFirst()) {
				
				retour = new ArrayList<>();

				while (result.next()) {
					Utilisateur util = new Utilisateur();
					util.setId(result.getInt(tableList[0]));
					util.setNom(result.getString(tableList[1]));
					util.setPrenom(result.getString(tableList[2]));
					util.setEmail(result.getString(tableList[3]));
					util.setPassword(result.getString(tableList[4]));
					util.setTelNum(result.getString(tableList[5]));
					util.setAdresse(result.getString(tableList[6]));
					util.setCodePostal(result.getString(tableList[7]));
					util.setSecureQ( result.getString(tableList[8]));
					util.setRepSecureQ(result.getString(tableList[9]));
					util.setImgLink(result.getString(tableList[10]));
					retour.add(util);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ConnexionBD.closeConnection();
		
		return retour;
	}
	
	public static Utilisateur getById(int id) {
		Utilisateur retour = null;
		
		try {
			PreparedStatement ps = (PreparedStatement) ConnexionBD.getConnection().prepareStatement(queryGetById);
			ps.setInt(1, id);
			
			ResultSet result = (ResultSet) ps.executeQuery();

			if (result.isBeforeFirst()) {
				
				retour = new Utilisateur();	
				
				while (result.next()) {					
					retour.setId(result.getInt(tableList[0]));
					retour.setNom(result.getString(tableList[1]));
					retour.setPrenom(result.getString(tableList[2]));
					retour.setEmail(result.getString(tableList[3]));
					retour.setPassword(result.getString(tableList[4]));
					retour.setTelNum(result.getString(tableList[5]));
					retour.setAdresse(result.getString(tableList[6]));
					retour.setCodePostal(result.getString(tableList[7]));
					retour.setSecureQ(result.getString(tableList[8]));
					retour.setRepSecureQ(result.getString(tableList[9]));
					retour.setImgLink(result.getString(tableList[10]));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConnexionBD.closeConnection();
		return retour;
	}
	
	public static Utilisateur getByEmail(String email) {
		Utilisateur retour = null;
		
		try {
			PreparedStatement ps = (PreparedStatement) ConnexionBD.getConnection().prepareStatement(queryGetByEmail);
			ps.setString(1, email);
			
			ResultSet result = (ResultSet) ps.executeQuery();

			if (result.isBeforeFirst()) {
				
				retour = new Utilisateur();	
				
				while (result.next()) {					
					retour.setId(result.getInt(tableList[0]));
					retour.setNom(result.getString(tableList[1]));
					retour.setPrenom(result.getString(tableList[2]));
					retour.setEmail(result.getString(tableList[3]));
					retour.setPassword(result.getString(tableList[4]));
					retour.setTelNum(result.getString(tableList[5]));
					retour.setAdresse(result.getString(tableList[6]));
					retour.setCodePostal(result.getString(tableList[7]));
					retour.setSecureQ(result.getString(tableList[8]));
					retour.setRepSecureQ(result.getString(tableList[9]));
					retour.setImgLink(result.getString(tableList[10]));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConnexionBD.closeConnection();
		return retour;
	}
	
	public static  ArrayList<Utilisateur> getBy(UTILISATEUR_TABLE table, String nom){
		String tableName = null;
		ArrayList<Utilisateur> retour = null;
		
		tableName = getTableName(table);
		
		try {
			
			PreparedStatement ps = (PreparedStatement) ConnexionBD.getConnection().prepareStatement(queryGetBy);
			ps.setString(1, tableName);
			ps.setString(2, nom);
			
			ResultSet result = (ResultSet) ps.executeQuery();

			if (result.isBeforeFirst()) {
				retour = new ArrayList<>();
				
				while (result.next()) {					
					Utilisateur util = new Utilisateur();
					
					util.setId(result.getInt(tableList[0]));
					util.setNom(result.getString(tableList[1]));
					util.setPrenom(result.getString(tableList[2]));
					util.setEmail(result.getString(tableList[3]));
					util.setPassword(result.getString(tableList[4]));
					util.setTelNum(result.getString(tableList[5]));
					util.setAdresse(result.getString(tableList[6]));
					util.setCodePostal(result.getString(tableList[7]));
					util.setSecureQ(result.getString(tableList[8]));
					util.setRepSecureQ(result.getString(tableList[9]));
					util.setImgLink(result.getString(tableList[10]));
				
					retour.add(util);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConnexionBD.closeConnection();
		
		return retour;
	}
	
	public static String getTableName(UTILISATEUR_TABLE table){
		String tableName = null;
		
		switch(table){
		// tableList[0] est "id_ut" (unique)
		
		case  NOM:
			tableName = tableList[1];
			break;
		case PRENOM:
			tableName = tableList[2];
			break;
	
		// tablelist[2] est email (unique)	
		// tableList[3] est password (priver)
			
		case TELNUM:
			tableName = tableList[5];
			break;
		case ADRESSE:
			tableName = tableList[6];
			break;
		case CODEPOSTAL:
			tableName = tableList[7];
			break;
		case SECURE_Q:
			tableName = tableList[8];
			break;
		case REP_SECURE_Q:
			tableName = tableList[9];
			break;	
		case IMG_LINK:
			tableName = tableList[10];
			break;		
		}

		return tableName;
	}
}
