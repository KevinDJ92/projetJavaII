<%@page import="org.omg.CORBA.SystemException"%>
<%@page import="com.controller.AfficherCategorieProd"%>
<%@page import="com.controller.AffichePhotoProd"%>
<%@page import="com.controller.AfficheCommentaires"%>
<%@page import="com.controller.AfficherProduit"%>
<%@page import="com.utils.Constante"%>
<%@page import="com.entities.Rating"%>
<%@page import="com.entities.PhotoProduit"%>
<%@page import="com.entities.Produit"%>
<%@page import="java.util.ArrayList"%>
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
//      		request.getRequestDispatcher("AfficherProduit").forward(request, response);
    		
    	}
    		
    	if(produits != null && request.getAttribute("listeRateValid")== null){
    		request.setAttribute("link", "index.jsp");
			AfficheCommentaires.RecupererAllRating(request);
//      		request.getRequestDispatcher("AfficheCommentaires").forward(request, response);
		}
    	
    	if(produits != null && request.getAttribute("listePhotoValid")== null){
    		request.setAttribute("link", "index.jsp");
	   		AffichePhotoProd.RecupererAllPhoto(request);

//      		request.getRequestDispatcher("AffichePhotoProd").forward(request, response);
    			
    	}
    	if(request.getAttribute("listeCategorieValid")== null){
    		request.setAttribute("link", "index.jsp");
   			AfficherCategorieProd.RecupererAllCategorie(request);
//      		request.getRequestDispatcher("AfficherCategorieProd").forward(request, response);
    			
    	}

		
    	
//     	if(request.getAttribute("listeProd")==null || request.getAttribute("listeRateValid")== null ||request.getAttribute("listePhotoValid")== null || request.getAttribute("listeCategorieValid")== null){
//     		request.getRequestDispatcher(Constante.cefErrorPage).forward(request, response);
//     	}
//     	else{

        	produits = (ArrayList<Produit>)request.getAttribute("listeProd");
    		Ratings = (ArrayList<Rating>)request.getAttribute("listRatingProd");
    		photoProds = (ArrayList<PhotoProduit>)request.getAttribute("listePhotoProd");
    		categories = (ArrayList<String>)request.getAttribute("listeCatProd");
    		
    		
//     	}
    %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Shop Homepage</title>

    <!-- Bootstrap Core CSS -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="bootstrap/css/shop-homepage.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <script type="text/javascript">
    	
    </script>

</head>

<body>

    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">Acceuil</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="produits.jsp">Nos Produits</a>
                    </li>
                    <li>
                        <a href="#">Services</a>
                    </li>
                    <li>
                        <a href="#">Contact</a>
                    </li>
                    
                    <li>
                        <a href="#">Mon panier</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

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
                	<p class="list-group-item"> il nya pas de categorie</p>
                <%
                }
                %>
                </div>
                 <div class="list-group">
                  <!--<form action="AfficherProduit" methode="get" class="list-group"> -->
                 	<input type="text" placeholder="Ecrire ta recherche ici"  class="list-group-item " id="nomProd">
                 	<input type="button" value="chercher" class="list-group-item chercher">
                 	
                 	<p class="list-group-item resultat"></p>
               <!-- </form> -->
                 
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
                                <h4 class="pull-right">$<%= produit.getPrix() %></h4>
                                <h4><a href="#"><%=produit.getNom() %></a>
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
    <!-- /.container -->

    <div class="container">

        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; Your Website 2014</p>
                </div>
            </div>
        </footer>

    </div>
    <!-- /.container -->

    <!-- jQuery -->
    <script type="text/javascript" src="bootstrap/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>

</body>
<script type="text/javascript" src="script/jquery-3.2.1.min.js"></script> 
<script type="text/javascript" src="script/ajaxTest.js"></script> 
</html>

