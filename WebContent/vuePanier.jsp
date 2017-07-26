<%@page import="java.sql.Date"%>
<%@page import="com.utils.Constante"%>
<%@page import="com.entities.*"%>
<%@page import="java.util.*"%>
<%@page import="com.controller.AfficherProduit"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
    <%
    if(session.getAttribute(Constante.clefSession)==null){
		
		response.sendRedirect("Login.jsp");
	}
    	HashMap<Integer,LigneCommande> monPanier=(HashMap<Integer,LigneCommande>)session.getAttribute("LePanier");
  		Achat achat= new Achat();
    	
    %>
    <%!
    	ArrayList<Achat> achats = new ArrayList();
    %>
    
    <jsp:include page="util/headerPart1.html"/>  
    <title>Panier</title>
	<jsp:include page="util/headerPart2.jsp"/>

    <!-- Page Content -->
    <div class="container">

        <div class="row">

            <div class="col-md-3">
                <p class="lead">Mon Compte</p>
                <div class="list-group">
                	<a href="#" class="list-group-item">Voir mon panier</a>
                	<a href="#" class="list-group-item">Mes promotions</a>
                	<a href="#" class="list-group-item">Modifier mon compte</a>
                </div>
                 
            </div>

            <div class="col-md-9">
              
                <div class="row rowProds">
				
					
					<div class="col-sm-10 col-lg-10 col-md-10 produitsAffiche">
                       <% 
	                      if(monPanier != null){
	                    	  double total = 0;
	                    	  for(Map.Entry<Integer, LigneCommande> entry : monPanier.entrySet()){
	                    		  total+=entry.getValue().getQuantite()*entry.getValue().getProduit().getPrix();
	                    	 
	                    	  
	                   %>
	                    	  
	                    <div class="thumbnail">
	                    	
	                    	<p>nom de l'article <%=entry.getValue().getProduit().getNom() %></p>
	                    	<p>La quantité de votre commande est : <%=entry.getValue().getQuantite() %></p>
	                    	<p>Le prix total pour cette article est <%=entry.getValue().getQuantite() %> * <%=entry.getValue().getProduit().getPrix()%> = <%=entry.getValue().getQuantite()*entry.getValue().getProduit().getPrix() %>$</p>
	                    </div>

	                   <%
	                   Utilisateur util = ((Utilisateur)session.getAttribute(Constante.clefSession));
	                   achat = new Achat(util.getId(),entry.getValue().getProduit().getId(),
	                		   			"abc123",null,"dfsdf","envoyer",entry.getValue().getQuantite());
	                  
	                   achats.add(achat);
	                  
	                    	  }
	                    	  %>
	                    	  
	                    	  <p>le total de votre achat est <%=total %>$ </p>
	                    	  <form action="ajoutAchat" methode="post">
	                    	  	<input type="submit" value="valider l'achat">
	                    	  </form>
	                    	 
	                    	  
	                    	  <%
	                      }
                       
	                      else{
	                    	  
	                   	 %>
	                    	  <p>vous n'avez rien dans votre panier</p>
	                   <%
	                      }
	                   %>
                    </div>
					

                </div>

            </div>

        </div>

    </div>
    <!-- /.container -->

   	<jsp:include page="util/footer.html"/>	
   	
	<script type="text/javascript" src="script/ajaxTest.js"></script> 
	<script type="text/javascript" src="script/CookieProduit.js"></script> 
</html>

