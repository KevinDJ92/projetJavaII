package com.controller.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LireCookies")
public class LireCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LireCookies() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = null;
		cookies = request.getCookies();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
			out.println("<html>"
						+ "<head>"
						+ "<title>Lire Cookie</title>"
						+ "</head>"
						+ "<body>");
		
		if (cookies != null){
			for (int i = 0; i < cookies.length; i++){
				out.println("<p>Cookie Nom" + i + ": " + cookies[i].getName() + "</p>");
				out.println("<p>Cookie Value " + i +  ": " + cookies[i].getValue() + "</p>");
			}
		}
		else {
			out.println("<p> Pas cookies trouvees. </p>");
		}
		out.println("<p><a href='formulaire.html'>Formulaire</a></p>"
				+ "<p><a href='../CookiesExample/SessionTrack'>SessionTrack</a></p>"
				+ "<p><a href='../CookiesExample/SuprimerCookies'>SuprimerCookies</a></p>"
				+ "</body>"
				+ "</html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
