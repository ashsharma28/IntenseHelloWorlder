package com.ashish.rest;


import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/helloWorldREST")
//http://localhost:8080/JAXRS-HelloWorld/rest/helloWorldREST/JavaCodeGeeks?value=enjoy-REST
public class HelloWorldREST {

	@GET
	@Path("/ashi")
	public Response responseMsg( @DefaultValue("Unknown") @QueryParam("value") String value) {
		
		String output = "Hello from: " + value;
		
		return Response.status(200).entity(output).build();
		
	}
}