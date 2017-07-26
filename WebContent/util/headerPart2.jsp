<%@page import="com.utils.Constante"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	
		<link href="css/img.css" rel="stylesheet">
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
<!-- 	                session.getAttribute(Constante.clefSession)==null -->
	                    <li>
	                        <a href="produits.jsp">Nos Produits</a>
	                    </li>              
	                    <li>
	                        <a href="vuePanier.jsp">Mon panier</a>
	                    </li>                
	                     <li>
	                        <a href="achats.jsp">Mes Achats</a>
	                    </li>
	                    <li>
	                        <a href="<%=(session.getAttribute(Constante.clefSession)==null?"Login.jsp":"disconnect")  %>"><%=(session.getAttribute(Constante .clefSession)==null?"Se connecter":"Se deconnecter")  %></a>
	                    </li>
	                     <li id="img-panier">
                        	<a href="vuePanier.jsp"><img src="img/util/p-panier.png"></a>
                    	</li>
	                </ul>
	            </div>
	            <!-- /.navbar-collapse -->
	        </div>
	        <!-- /.container -->
	    </nav>