package com.manager;

import java.sql.SQLException;

import com.entities.Utilisateur;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.service.ConnexionBD;

public class UtilisateursManager {
	private static String queryGetyAll = "SELECT * FROM utilisateurs";
	private static String queryGetById = "SELECT * FROM utilisateurs WHERE id = ?";
	private static String queryInsert = "INSERT INTO utilisateurs(nom, prenom, email, password, tel_num, adresse, code_postal, secure_q, rep_secure_q, photo_profil) VALUE(?,?,?,?,?,?,?,?,?,?)";
	private static String queryUpdate = "UPDATE utilisateurs SET nom = ?, prenom = ?, email = ?, password = ?, tel_num = ?, adresse = ?, code_postal = ?, secure_q = ?, rep_secure_q = ?, photo_profil = ?";
	private static String queryDelete = "DELETE FROM utilisateurs WHERE id = ?";
	private static String queryConnexion = "SELECT * FROM utilisateurs WHERE email= ? AND password= ?";
	
	public static Utilisateur getById(int id) {
		Utilisateur retour = null;
		
		try {
			PreparedStatement ps = (PreparedStatement) ConnexionBD.getConnection().prepareStatement(queryGetById);
			ps.setInt(1, id);
			
			ResultSet result = (ResultSet) ps.executeQuery();

			if (result.isBeforeFirst()) {
				
				retour = new Utilisateur();

//				private int id;
//				private String nom;
//				private String prenom;
//				private String email;
//				private String password;
//				private String telNum;
//				private String adresse;
//				private String codePostal;
//				private String secureQ;
//				private String repSecureQ;
//				private String imgLink;
				
				
				while (result.next()) {					
					retour.setId(result.getInt("id"));
					retour.setNom(result.getString("nom"));
					retour.setPrenom(result.getString("prenom"));
					retour.setEmail(result.getString("email"));
					retour.setPassword(result.getString("password"));
					retour.setTelNum(result.getString("telNumero"));
					retour.setAdresse(result.getString("adresse"));
					retour.setCodePostal(result.getString("codePostal"));
					retour.setSecureQ(result.getString("secureQ"));
					retour.setRepSecureQ(result.getString("repSecureQ"));
					retour.setImgLink(result.getString("photoProfil"));
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
