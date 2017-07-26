<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  
<%@page import="com.entities.Utilisateur"%>
<%@page import="com.manager.UtilisateursManager"%>
<%@page import="java.util.ArrayList"%>

<%
	Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur");
%>    
	<jsp:include page="util/headerPart1.html"/>
	<title>Inscription</title>
	<jsp:include page="util/headerPart2.html"/>
	 	
	 	<h1>Inscription</h1>
		<fieldset>
			<legend>Veuillez entrer vos informations personnelles</legend>
			<form action="ModifierUtilisateur" method="post">
				Nom      <input type="text" name="nomInsert" value="" /> 	   	   <br/>
				Prenom   <input type="text" name="prenomInsert" value="" />        <br/>
				Email    <input type="text" name="emailInsert" value=""/>           <br/>
				Password <input type="password" name="passwordInsert" value=""/> <br/> 
				Confirm Password <input type="password" name="passwordConfirmInsert" value=""/> <br/>
 				Numero Telephone <input type="text" name="telephoneInsert" value=""/> <br/>
 				Adresse <input type="text" name="adresseInsert" value=""/> <br/>
				Code Postal <input type="text" name="codePostalInsert" value=""/> <br/>
 				<label> Question Security 
				</label> <select name="questionSecurityInsert">
    				<option value="Q1">Who was your childhood hero?</option>
				    <option value="Q2">What was the name of your elementary school</option>
				    <option value="Q3">In which city were you born?</option>
 				 </select>
 				 <br/>
				Reponse Security  <input type="text" name="reponseSecurityInsert" value=""/> <br/>
				Photo De Profil <input type="text" name="imgLinklInsert" value=""/> <br/>			
				<input type="submit" value="Envoyer" />
			</form>
		</fieldset>

	<jsp:include page="util/footer.html"/>	  
</html> 