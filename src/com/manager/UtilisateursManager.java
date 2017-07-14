package com.manager;

import java.sql.SQLException;
import java.util.ArrayList;

import com.entities.Utilisateur;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import com.service.ConnexionBD;

public class UtilisateursManager {
	private static String queryGetyAll = "SELECT * FROM utilisateurs";
	private static String queryGetById = "SELECT * FROM utilisateurs WHERE id = ?";
	private static String queryInsert = "INSERT INTO utilisateurs(nom, prenom, email, password, tel_num, adresse, code_postal, secure_q, rep_secure_q, photo_profil) VALUE(?,?,?,?,?,?,?,?,?,?)";
	private static String queryUpdate = "UPDATE utilisateurs SET nom = ?, prenom = ?, email = ?, password = ?, tel_num = ?, adresse = ?, code_postal = ?, secure_q = ?, rep_secure_q = ?, photo_profil = ?";
	private static String queryDelete = "DELETE FROM utilisateurs WHERE id = ?";
	private static String queryConnexion = "SELECT * FROM utilisateurs WHERE email= ? AND password= ?";
	
	public static ArrayList<Utilisateur> getAll() {
		ArrayList<Utilisateur> retour = null;

		try {
			PreparedStatement ps =  (PreparedStatement) ConnexionBD.getConnection().prepareStatement(queryGetyAll);
			ResultSet result = (ResultSet) ps.executeQuery();

			if (result.isBeforeFirst()) {
				
				retour = new ArrayList<>();

				while (result.next()) {
					Utilisateur util = new Utilisateur();
					util.setId(result.getInt("id_ut"));
					util.setNom(result.getString("nom"));
					util.setPrenom(result.getString("prenom"));
					util.setEmail(result.getString("email"));
					util.setPassword(result.getString("password"));
					util.setTelNum(result.getString("tel_num"));
					util.setAdresse(result.getString("adresse"));
					util.setCodePostal(result.getString("code_postal"));
					util.setSecureQ( result.getString("secure_q") );
					util.setRepSecureQ(result.getString("rep_secure_q"));
					util.setImgLink(result.getString("photo_profil"));
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
					retour.setId(result.getInt("id_ut"));
					retour.setNom(result.getString("nom"));
					retour.setPrenom(result.getString("prenom"));
					retour.setEmail(result.getString("email"));
					retour.setPassword(result.getString("password"));
					retour.setTelNum(result.getString("tel_num"));
					retour.setAdresse(result.getString("adresse"));
					retour.setCodePostal(result.getString("code_postal"));
					retour.setSecureQ(result.getString("secure_q"));
					retour.setRepSecureQ(result.getString("rep_secure_q"));
					retour.setImgLink(result.getString("photo_profil"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConnexionBD.closeConnection();
		return retour;
	}
	
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
		
		if(nbLigne >0 )
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
	

}
