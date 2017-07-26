<%@page import="org.omg.CORBA.SystemException"%>
<%@page import="com.controller.AfficherCategorieProd"%>
<%@page import="com.controller.AffichePhotoProd"%>
<%@page import="com.controller.AfficheCommentaires"%>
<%@page import="com.controller.AfficherProduit"%>
<%@page import="com.utils.Constante"%>
<%@page import="com.entities.Rating"%>
<%@page import="com.entities.PhotoProduit"%>
<%@page import="com.entities.Produit"%>
<%@page import="com.entities.LigneCommande"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%!
    	ArrayList<Rating> Ratings = null;
   		ArrayList<Produit> produits = null;
   		ArrayList<PhotoProduit> photoProds =null;
   		ArrayList<String>categories = null;
   		PhotoProduit photoForProd = null ; 
   		int note = 0;	
    %>
    <%
    	if(request.getAttribute("listeProd")==null && request.getAttribute("listeProdValid")== null){
    		request.setAttribute("link", "index.jsp");
   			AfficherProduit.RecupererAllProd(request);    		
    	}
    		
    	if(produits != null && request.getAttribute("listeRateValid")== null){
    		request.setAttribute("link", "index.jsp");
			AfficheCommentaires.RecupererAllRating(request);
		}
    	
    	if(produits != null && request.getAttribute("listePhotoValid")== null){
    		request.setAttribute("link", "index.jsp");
	   		AffichePhotoProd.RecupererAllPhoto(request);
    	}
    	if(request.getAttribute("listeCategorieValid")== null){
    		request.setAttribute("link", "index.jsp");
   			AfficherCategorieProd.RecupererAllCategorie(request);		
    	}

        produits = (ArrayList<Produit>)request.getAttribute("listeProd");
    	Ratings = (ArrayList<Rating>)request.getAttribute("listRatingProd");
    	photoProds = (ArrayList<PhotoProduit>)request.getAttribute("listePhotoProd");
    	categories = (ArrayList<String>)request.getAttribute("listeCatProd");
    		
    	boolean monPanierExist = false;
       	int nombreAticle = 0;
          	
        Integer testNombreArticle = (Integer) request.getAttribute("nombreArticle");
          	
        if(testNombreArticle!=null){
          	nombreAticle=testNombreArticle;
          	monPanierExist=true;
          }
          	
         HashMap<Integer,LigneCommande> monPanier = (HashMap<Integer,LigneCommande>)session.getAttribute("LePanier");
    %>
   	<jsp:include page="util/headerPart1.html"/>
   	<title>Produits</title>
   	<link href="css/light_box.css" rel="stylesheet">
	<jsp:include page="util/headerPart2.html"/>
	
    <!-- Page Content -->
    <div class="container">
        <div class="row">

            <div class="col-md-3">
                <p class="lead">Nos categories</p>
                <div class="list-group">
                <%
                if(categories != null){
                	for(String categorie : categories){
                %>
                    <a href="AfficherProduit?categorie=<%=categorie %>" class="list-group-item"><%=categorie %></a>
                <%
                	}
                }
                
                else{
                	%>
                	<p class="list-group-item"> il n'y a pas de categorie</p>
                <%
                }
                %>
                </div>
                 <div class="list-group">
                   	<form action="AfficherProduit" methode="get" class="list-group">
	                 	<input list="nomRecherche" type="text" placeholder="Ecrire ta recherche ici" name="nomProd"  class="list-group-item " id="nomProd">
	                 	<datalist id="nomRecherche">  
						</datalist>               	
	                 	<input type="submit" value="chercher" class="list-group-item chercher">	                 	
	                 	<p class="list-group-item resultat"></p>
               		</form>           
                 </div>
            </div>

            <div class="col-md-9">
                <div class="row carousel-holder">

                    <div class="col-md-12">
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            </ol>
                            <div class="carousel-inner">
                                <div class="item active">
                                    <img class="slide-image" src="http://placehold.it/800x300" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="http://placehold.it/800x300" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="http://placehold.it/800x300" alt="">
                                </div>
                            </div>
                            <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left"></span>
                            </a>
                            <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right"></span>
                            </a>
                        </div>
                    </div>

                </div>
                

                <div class="row rowProds">
				
				<%
                	if(produits != null){
                		//System.out.println("je test");
                %>
                
					<%
						for(Produit produit : produits){
							if(photoProds != null){
							for(PhotoProduit photo : photoProds){
								if(photo.getIdProd() == produit.getId() && photo.getIsDefault()==1){
									photoForProd = photo;
								}

							}
								
							}
							if(Ratings != null){
							
								for(Rating rating : Ratings){
									if(rating.getIdProduit() == produit.getId()){
										note ++;
									}
									
									
	
								}
							}
					%>
					
					<div class="col-sm-4 col-lg-4 col-md-4 produitsAffiche">
                        <div class="thumbnail">
                        	<input type="button" class="btn-panier" value="ajouter au panier">
                            <img src="img/produits/<%=(photoForProd!=null?photoForProd.getCheminFtp():"default.jpg")  %>" alt="<%= (photoForProd!=null?photoForProd.getAlt():"") %>"
                            	class="imgProd">
                            <div class="caption">
                            	<input type="hidden" class="produitId" value="<%= produit.getId() %>">
                                <h4 class="pull-right produitPrix">$<%= produit.getPrix() %></h4>
                                <h4><a href="#" class="produitNom"><%=produit.getNom() %></a>
                                </h4>
                                <p><%=produit.getDetail() %> .</p>
                            </div>
                            <div class="ratings">
                                <p class="pull-right"><%= note %></p>
                                <p><%
                                for(int i=0 ; i<note ; i++){
                                	
                                
                                %>
                               
                                    <span class="start_<%=i+1 %> glyphicon glyphicon-star modifiable"></span>
                                    
                                <%
                                }
                                if(note<5){
                                	for(int j=note ; j<5 ; j++){
                                		
                                %>
                                 <span class="start_<%=j+1 %> glyphicon glyphicon-star-empty modifiable"></span>
                                <%
                                	}
                                }
                                %>
                                   
                                </p>
                            </div>
                        </div>
                    </div>
					
					<%
					note =0;
						}
                	}
                	else{%>
                	
                		<p>desole il ya aucun produits</p>
                		<%
                	}
					%>

                </div>

            </div>

        </div>

    </div>
    <div id="lightBoxBg"></div>
    <div id="lightBox">
    	<button id="close">X</button>
	    <img src="" alt="" class="imgProd"><br>
		<label>Nom: </label>
		<label id="nomDuProduit"></label><br>
		<label>Prix: </label>
		<label id="prixDuProduit"></label>
		<form id="formQuantite" method="get" action="GererPanier">
			<input id="idDuProduit" type="hidden" value="" name="idProduit"/>
			<input type="text" value="" name="quantite"/>
			<input type="submit" name="btsubmit" value="Ajouter au Panier"/>
		</form>
    </div>
  	
  	<jsp:include page="util/footer.html"/>	
	
	<script type="text/javascript" src="script/ajaxTest.js"></script> 
	<script type="text/javascript" src="script/CookieProduit.js"></script> 
	<script type="text/javascript" src="script/lightBox.js"></script> 
</html>

