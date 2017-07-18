package com.controller.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SuprimerCookies")
public class SuprimerCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public SuprimerCookies() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = null;
		String[] cook_nom = null;
		cookies = request.getCookies();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
			out.println("<html>"
							+ "<head>"
								+ "<title>Suprimer Cookie</title>"
							+ "</head>"
						+ "<body>");
		
		if (cookies != null){
			for (int i = 0; i < cookies.length; i++){	
				cook_nom[i] = cookies[i].getName();
			}
			
			for (int i = 0; i < cookies.length; i++){
				if ((cookies[i].getName()).compareTo(cook_nom[i]) == 0){
					cookies[i].setMaxAge(0);
					out.println("<p> Cookie " + i +" supprimer: " + cookies[i] + "</p>");
				}
			}
		}
		else {
			out.println("<p> Pas cookies trouvees. </p>");
		}
		
		out.println( "<p><a href='formulaire.html'>Formulaire</a></p>"
				  + "<p><a href='../CookiesExample/LireCookies'>Lire Cookies</a></p>"
				  + "<p><a href='../CookiesExample/SessionTrack'>SessionTrack</a></p>"
				  	+ "</body>"
			      + "</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
