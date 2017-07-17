<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.action.UtilisateurAction "%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>
	</head>
	<body>
		<form class="form-signin" action="LoginUtilisateur" method="get">
			<input type="text"name="email" placeholder="Email" required autofocus>
			<input type="password" name="password" placeholder="Password" required>
		    <button type="submit"> Sign in</button>
			<input type="checkbox" name="sauvegarde" value="yes">
			Remember me </br>
	   	</form>
	</body>
</html>