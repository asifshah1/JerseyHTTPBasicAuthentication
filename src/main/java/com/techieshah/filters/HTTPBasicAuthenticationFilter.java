package com.techieshah.filters;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response.Status;
import javax.xml.bind.DatatypeConverter;

/**
 * @author techieshah.blogspot.com
 *
 */
public class HTTPBasicAuthenticationFilter implements ContainerRequestFilter{

	@Context
	HttpServletRequest httpServletRequest;	

	public void filter(ContainerRequestContext containerRequest) throws IOException {
		final String AUTHENTICATION_HEADER = "Authorization";
		String auth = containerRequest
				.getHeaderString(AUTHENTICATION_HEADER);
        
        if(auth == null){
        	throw new WebApplicationException(Status.UNAUTHORIZED);
        }      
        
        String lap[] = decode(auth);       
        
      //If login or password fail
        if(lap == null || lap.length < 2){
            throw new WebApplicationException(Status.UNAUTHORIZED);
        }
       
        if( ! ( "testUser".equals( lap[0] ) || "test01".equals( lap[1] ) ) ){
        	throw new WebApplicationException(Status.UNAUTHORIZED);
        }
	}
	
	private String[] decode(String auth) {
        //Replacing "Basic THE_BASE_64" to "THE_BASE_64" directly
        auth = auth.replaceFirst("[B|b]asic ", "");
        byte[] bytes = DatatypeConverter.parseBase64Binary(auth);
        
        if(bytes == null || bytes.length == 0){
            return null;
        }
        return new String(bytes).split(":",2);              
    }
}
