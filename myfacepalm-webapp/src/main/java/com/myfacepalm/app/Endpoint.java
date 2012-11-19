package com.myfacepalm.app;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * REST connector
 * 
 * TODO: there should be more than one "like" emotion 
 * 
 * @author Volodymyr_Krasnikov
 */
@Path("/like/{url}")
@Produces("application/json")
public interface Endpoint {

	@POST
	Response like(@PathParam("url") String pictureUrl, @FormParam("host") String owningHost);
	
	@GET
	Response count(@PathParam("url") String pictureUrl);
	
}
