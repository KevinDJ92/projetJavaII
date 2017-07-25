<%@page import="com.utils.Constante"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
    	if(session.getAttribute(Constante.clefSession)==null){
    		
    		response.sendRedirect("Login.jsp");
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
                    
                     <li>
                        <a href="achats.jsp">Mes Achats</a>
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
                <p class="lead">Mon Compte</p>
                <div class="list-group">
                	<a href="#" class="list-group-item">Voir mon panier</a>
                	<a href="#" class="list-group-item">Mes promotions</a>
                	<a href="#" class="list-group-item">Modifier mon compte</a>
                </div>
                 
            </div>

            <div class="col-md-9">
              
                <div class="row rowProds">
				
					
					<div class="col-sm-4 col-lg-4 col-md-4 produitsAffiche">
                       
                    </div>
					

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
	<script type="text/javascript" src="script/CookieProduit.js"></script> 
</html>

