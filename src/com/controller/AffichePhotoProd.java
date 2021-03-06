package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.PhotoAction;
import com.action.RatingAction;
import com.utils.Constante;

@WebServlet("/AffichePhotoProd")
public class AffichePhotoProd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AffichePhotoProd() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String urlRedirect = Constante.cefErrorPage;
		String linkR = (String)request.getAttribute("link");

		
		if(linkR == null){
			linkR = "index.jsp";
		}

		String idProd = request.getParameter("idProd");
		
		
			if(idProd == null){
				if(PhotoAction.afficherPhotoProd(request)){
					urlRedirect = linkR;
					
					
				}
			}else{
				if(idProd !=null){
					if(PhotoAction.afficherPhotoProdwithId(request, Integer.parseInt(idProd))){
						urlRedirect = linkR;
						request.setAttribute("listePhotoValid", "true");
						request.getRequestDispatcher(urlRedirect).forward(request, response);
						
					}
				}
			}
			
			
//			request.getRequestDispatcher(urlRedirect).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public static boolean RecupererAllPhoto(HttpServletRequest request){
		request.setAttribute("listePhotoValid", "true");
		return PhotoAction.afficherPhotoProd(request);
	}


}
