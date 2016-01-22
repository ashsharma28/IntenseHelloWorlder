package com.ashish.rest;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;


import com.google.appengine.api.utils.SystemProperty;

@Path("/helloWorldREST")
//http://localhost:8080/JAXRS-HelloWorld/rest/helloWorldREST/JavaCodeGeeks?value=enjoy-REST
public class HelloWorldREST {

	@GET
	@Path("/ashi")
	public Response responseMsg( /*@DefaultValue("Unknown") @QueryParam("value") String value*/)
	{
		
		final Logger log = Logger.getLogger(HelloWorldREST.class.getName());
		  log.info("Your information log message.");


	    String url = null;
	    Response response1 = null;
	    String out = "ASHISH + Code :-  ";
	    
	    log.info("ASDFGHJKLKJHGFDSASDFGHJKLJHGFDSA");
	   
	    try 
	    {
	      
			      if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) 
			      {
			        // Load the class that provides the new "jdbc:google:mysql://" prefix.
			        Class.forName("com.mysql.jdbc.GoogleDriver");
			        url = "jdbc:google:mysql://intensehelloworlder:intense-database2/Test";
			        
			        log.info("STAGE ASHISH SHARMA 2");
			      }
			      else 
			      {
			        // Local MySQL instance to use during development.
			        Class.forName("com.mysql.jdbc.Driver");
			        url = "jdbc:mysql://localhost:3306/test";
			        log.info("STAGE ASHISH SHARMA 3");
			
			        // Alternatively, connect to a Google Cloud SQL instance using:
			        
			        // jdbc:mysql://ip-address-of-google-cloud-sql-instance:3306/guestbook?user=root
			      }
	    } 
	    
	    catch (Exception e) 
	    {
	      e.printStackTrace();
	      log.info("STAGE ASHISH SHARMA 4");

	      response1  = Response.status(200).entity("Errorrorinr Ashish" ).build(); ;
	    }
	    

	    
	    
	    try 
	    {
	    	
	    	log.info("STAGE ASHISH SHARMA 5 $$$$$$$$#########$$$$$$$$");

	      Connection conn = DriverManager.getConnection(url, "root" , "stunner28");
	      
	      try 
	      {
		    	  
						int fname = 3 ;
            String content = "BTech Student";
		        
		        if (fname == "" || content == "") {
		          out.concat(
		              "<html><head></head><body>You are missing either a message or a name! Try again! " +
		              "Redirecting in 3 seconds...</body></html>");
		        } 
		        else 
		        {
		          String statement = "INSERT INTO entries (entryID, content) VALUES( ? , ? )" ;
		          PreparedStatement stmt = conn.prepareStatement(statement);
		          stmt.setInt(1, fname);
		          stmt.setString(2, content);
		          
		          int success = 2;
		          success = stmt.executeUpdate();
		          if (success == 1) 
		          {
		        	  out.concat("<html><head></head><body>Success! Redirecting in 3 seconds...</body></html>");
		          } else if (success == 0) {
		            out.concat(
		                "<html><head></head><body>Failure! Please try again! " +
		                "Redirecting in 3 seconds...</body></html>");
		          }
		        }
		        
		       

		   	}
	      	finally
		    {
	      		response1 = Response.status(200).entity(out).build();
	      		conn.close();
		        
		    }
	      
	       

	    }
	    catch (SQLException e) 
	    {
	      e.printStackTrace();
	        response1 = Response.status(200).entity("out 123432" + e).build();

	    }
	    
	    
	    
	    	    
		return response1;

	  
	
	}
		/*String output = "Hello from: " + value;
		
		return Response.status(200).entity(output).build();*/
		
}