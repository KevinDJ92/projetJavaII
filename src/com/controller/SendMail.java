package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utils.GestionMail;

@WebServlet("/sendMail")
public class SendMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SendMail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = "Bienvenue Mr Z bienvenue a ISI";
		String to = "marouen.cherif@gmail.com";
		String sujet = "Ceci est un message important";
		PrintWriter out = response.getWriter();
		out.println("Message transmis avec succes");
		 out.println(
			        "<html>\n" +
			        "<head><title>" + sujet + "</title></head>\n" +
			        "<body bgcolor=\"#f0f0f0\">\n" +
			        "<h1 align=\"center\">" + sujet + "</h1>\n" +
			        "<p align=\"center\">" + msg + "</p>\n" +
			        "</body></html>");
		
		GestionMail.sendEmail(msg, to, sujet);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
