<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.manager.ProduitManager"%>
<%@page import="com.entities.Produit"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
  /* Produit produit = new Produit("hfhfh","qwerty",4,"neuf","hdjf",1.5);
 	ProduitManager.insert(produit); */

 	ArrayList<Produit> produits = (ArrayList<Produit>)request.getAttribute("listeProd");
if(produits!=null){
for(Produit prod : produits){
	
	%>
	<p>Nom Produit <%=prod.getNom() %></p>
	<p>detail de produit <%=prod.getDetail() %></p>
	<p>prix Produit <%=prod.getPrix() %></p>
	<p>etat Produit <%=prod.getEtat() %></p>
	<p>categorie Produit <%=prod.getCategorie() %></p>
	<p>qte Produit <%=prod.getQte() %></p>
	
<%
	}

	
}
else{
	%>
	<p>y a rien </p>

<%
}
%> 

</body>
</html>