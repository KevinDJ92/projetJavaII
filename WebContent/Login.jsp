<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

  	<jsp:include page="util/headerPart1.html"/>
	<link href="css/center.css" rel="stylesheet">
	<jsp:include page="util/headerPart2.html"/>

    <!-- Page Content -->
    <div class="container">
        <div class="row center borderBlack">
            <div class="col-md-9">      
                <div class="row rowProds">
					<form class="form-signin center" action="LoginUtilisateur" method="post">
						<input type="text"name="email" placeholder="Email" required autofocus><br>
						<input type="password" name="password" placeholder="Password" required><br>
			   			<button type="submit"> Sign in</button>
						<input type="checkbox" name="sauvegarde" value="yes">
						Remember me </br>
	   				</form>
                </div>
            </div>
        </div>
    </div>

  	<jsp:include page="util/footer.html"/>	 
	
	<script type="text/javascript" src="script/ajaxTest.js"></script> 
	<script type="text/javascript" src="script/CookieProduit.js"></script> 
</html>