<%@page import="com.entities.*"%>
<%@page import="java.util.*"%>
<%@page import="com.controller.AfficherProduit"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
    <%
	if(request.getAttribute("listeProd")==null && request.getAttribute("listeProdValid")== null){
			AfficherProduit.RecupererAllProd(request);
		//  request.getRequestDispatcher("AfficherProduit").forward(request, response);	
	}
    
    	ArrayList<Produit> listProduit=new ArrayList<Produit>();
    	listProduit = (ArrayList<Produit>)request.getAttribute("listeProd");
    	
    	boolean monPanierExist = false;
    	int nombreAticle = 0;
    	
    	Integer testNombreArticle = (Integer) request.getAttribute("nombreArticle");
    	
    	if(testNombreArticle!=null){
    		nombreAticle=testNombreArticle;
    		monPanierExist=true;
    	}
    	
    	HashMap<Integer,LigneCommande> monPanier=(HashMap<Integer,LigneCommande>)session.getAttribute("LePanier");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Ventes</title>
</head>
	<body>
		<p>Nombre d'article dans votre panier : <a href=''><%=nombreAticle %></a></p>
	
		<table border='1' width='50%' height='50%'>
				<tr><td></td> <td>Prix</td><td>Panier</td></tr>
				<%
					for(Produit produit : listProduit){
						int quantiteCommandee = 0;
						Integer idProduit=produit.getId();
						if(monPanierExist){
							if (monPanier.containsKey(idProduit)) {
								LigneCommande ligneCommande=monPanier.get(idProduit);
								quantiteCommandee=ligneCommande.getQuantite();
							}
						}
				%>
				<tr>
				<td><%=produit.getNom() %></td>
				<td><%=produit.getPrix() %></td>
				<td>
					<form id="formQuantite" method="get" action="GererPanier">
						<input type="submit" name="btsubmit" value="+"/>
						&nbsp;&nbsp;<input type="text" value="<%=quantiteCommandee %>" name="quantite" />&nbsp;&nbsp;
						<input type="hidden" name="id" value="<%=idProduit %>" />
						<input type="hidden" name="prix" value="<%=produit.getPrix() %>" />
						<input type="submit" name="btsubmit" value="-"/>
					</form>
				</td>
				</tr>
				<% } %>
		</table>
	</body>
</html>