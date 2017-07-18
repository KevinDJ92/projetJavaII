<%@page import="com.entities.Rating"%>
<%@page import="com.entities.PhotoProduit"%>
<%@page import="com.entities.Produit"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    
    	if(request.getAttribute("listeProd")==null){
    		request.getRequestDispatcher("AfficherProduit").forward(request, response);
    		
    	}
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

</head>

<body>

<%
 	ArrayList<Produit> produits = (ArrayList<Produit>)request.getAttribute("listeProd");
	ArrayList<PhotoProduit> photoProds = (ArrayList<PhotoProduit>)request.getAttribute("listePhotoProd");
	ArrayList<Rating> Ratings = (ArrayList<Rating>)request.getAttribute("listRatingProd");
	PhotoProduit photoForProd = null ;
// 	int note = 0;
%>
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
                <a class="navbar-brand" href="#">Start Bootstrap</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="#">About</a>
                    </li>
                    <li>
                        <a href="#">Services</a>
                    </li>
                    <li>
                        <a href="#">Contact</a>
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
                <p class="lead">Shop Name</p>
                <div class="list-group">
                    <a href="#" class="list-group-item">Category 1</a>
                    <a href="#" class="list-group-item">Category 2</a>
                    <a href="#" class="list-group-item">Category 3</a>
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

                <div class="row">

					<%
						for(Produit produit : produits){
							for(PhotoProduit photo : photoProds){
								if(photo.getIdProd() == produit.getId() && photo.getIsDefault()==1){
									photoForProd = photo;
								}

								
								
							}
							
// 							for(Rating rating : Ratings){
// // 								if(rating.getIdProduit() == produit.getId()){
// // 									note ++;
// // 								}
								
								

// 							}
					%>
					
					<div class="col-sm-4 col-lg-4 col-md-4">
                        <div class="thumbnail">
                            <img src="img/produits/<%=(photoForProd!=null?photoForProd.getCheminFtp():"")  %>" alt="<%= (photoForProd!=null?photoForProd.getAlt():"") %>">
                            <div class="caption">
                                <h4 class="pull-right">$<%= produit.getPrix() %></h4>
                                <h4><a href="#"><%=produit.getNom() %></a>
                                </h4>
                                <p><%=produit.getDetail() %> .</p>
                            </div>
                            <div class="ratings">
                                <p class="pull-right"></p>
                                <p><%
                               // for(int i=0 ; i<note ; i++){
                                	
                                
                                %>
                               
                                    <span class="start_ glyphicon glyphicon-star modifiable"></span>
                                    
                                <%
                                //}
                                //if(note<5){
                                	//for(int j=note ; j<5 ; j++){
                                		
                                %>
                                 <span class="start_ glyphicon glyphicon-star-empty modifiable"></span>
                                <%
                                	//}
                            //    }
                                %>
                                   
                                </p>
                            </div>
                        </div>
                    </div>
					
					<%
					//note =0;
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
    <script src="bootstrap/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="bootstrap/js/bootstrap.min.js"></script>

</body>

</html>
