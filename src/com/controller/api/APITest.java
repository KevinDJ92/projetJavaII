package com.controller.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class APITest {

	@GET
	@Produces(MediaType.TEXT_XML)
	public String ressoureXML(){
		String ressource = null;
		
		return ressource;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String ressoureJSON(){
		String ressource = null;
		
		return ressource;
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String ressoureHTML(){
		String ressource = null;
		
		return ressource;
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHelloHTML(@QueryParam("name") String name, @QueryParam("Card_no") String Card_no){
		String response = "";
		
		
		return response;
	}
}
