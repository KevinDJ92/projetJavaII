<%@page import="com.entities.Utilisateur"%>
<%@page import="com.manager.UtilisateursManager"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur");
%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Inscription</title>
	</head>
	<body>
	<%-- <%	Utilisateur user = new Utilisateur(1, "a", "b", "c", "d","e", "f", "g", "h", "e","j");
 	UtilisateursManager.insert(user); 
 	%> --%>
	
	 	<h1>Inscription</h1>
		<fieldset>
			<legend>Veuillez entrer vos informations personnelles</legend>
			<form action="modifierEtudiant" method="post">
				Nom      <input type="text" name="nomInsert" value="<%=(utilisateur !=null ? utilisateur.getNom() : "") %>" /> 	          <br/>
				Prenom   <input type="text" name="prenomInsert" value="<%=(utilisateur !=null ? utilisateur.getPrenom():"")%>" />        <br/>
				Email    <input type="text" name="emailInsert" value="<%=(utilisateur !=null ? utilisateur.getEmail():"")%>"/>           <br/>
				Password <input type="password" name="passwordInsert" value="<%=(utilisateur !=null ? utilisateur.getPassword():"")%>"/> <br/> 
				Confirm Password <input type="password" name="passwordConfirmInsert" value="<%=(utilisateur !=null ? utilisateur.getPassword():"")%>"/> <br/>
 				Numero Telephone <input type="text" name="telephoneInsert" value="<%=(utilisateur !=null ? utilisateur.getTelNum():"")%>"/> <br/>
 				Adresse <input type="text" name="adresseInsert" value="<%=(utilisateur !=null ? utilisateur.getAdresse():"")%>"/> <br/>
				Code Postal <input type="text" name="codePostalInsert" value="<%=(utilisateur !=null ? utilisateur.getCodePostal():"")%>"/> <br/>
 				<label> Question Security 
				</label> <select name="questionSecurityInsert">
    				<option value="Q1">Who was your childhood hero?</option>
				    <option value="Q2">What was the name of your elementary school</option>
				    <option value="Q3">In which city were you born?</option>
 				 </select>
				Reponse Security  <input type="text" name="reponseSecurityInsert" value="<%=(utilisateur !=null ? utilisateur.getRepSecureQ():"")%>"/> <br/>
				Photo De Profil <input type="text" name="imgLinklInsert" value="<%=(utilisateur !=null ? utilisateur.getImgLink():"")%>"/> <br/>				<br/>
				<input type="submit" value="Envoyer" />
			</form>
		</fieldset>
	</body>
</html>