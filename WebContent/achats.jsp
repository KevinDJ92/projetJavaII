<%@page import="com.entities.AchatProduit"%>
<%@page import="com.utils.Constante"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
	<%!
    	ArrayList<AchatProduit> achatProduits = null;
    %>
    
    <%
    	if(session.getAttribute(Constante.clefSession)==null){  		
    		response.sendRedirect("Login.jsp");
    	}
    	
    	else if (request.getAttribute("mesAchats") == null){
    		request.getRequestDispatcher("AfficherAchat").forward(request, response);
    	
    		achatProduits = (ArrayList<AchatProduit>)request.getAttribute("mesAchats");
    	}
    %>
  	<jsp:include page="util/headerPart1.html"/>
  	<title>Achat</title>
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
					<%
	                	if(achatProduits != null){
	                %>
	                
						<%
							for(AchatProduit achatProduit : achatProduits){
						 %>
							<div class="col-sm-4 col-lg-4 col-md-4 produitsAffiche">
								<img src="img/produits/<%=(achatProduit!=null?achatProduit.getFtpCheminImg():"default.jpg") %>" 
									alt="<%= achatProduit.getAltImg() %>"/>              			
	                            <p>Nom: <%= achatProduit.getNomAchat() %></p>
	                            <p>Prix: <%= achatProduit.getPrixAchat() %></p>
	                            <p>Quantiter: <%= achatProduit.getQuantiteAchat() %></p>
	                           <p>Detail: <%= achatProduit.getDetailAchat() %></p>
	                   		</div>
	                    <%
							}}
						 %> 
	                </div>
	            </div>
	        </div>
	    </div>
	
		<jsp:include page="util/footer.html"/>	

		<script type="text/javascript" src="script/ajaxTest.js"></script> 
		<script type="text/javascript" src="script/CookieProduit.js"></script> 
</html>

