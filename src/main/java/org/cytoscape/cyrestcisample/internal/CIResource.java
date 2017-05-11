package org.cytoscape.cyrestcisample.internal;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import org.cytoscape.ci.CIWrapping;

@Path("/wrappedgreeting")
public interface CIResource {

    @GET
    @CIWrapping
    @Produces(MediaType.APPLICATION_JSON)
    public SimpleMessage success();
    
    @Path("/fail")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public SimpleMessage fail() throws Exception;
    
    @Path("/failwithresource")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@CIWrapping
	public SimpleMessage failWithCIError() throws WebApplicationException;
    
    @Path("/failwithautolinkresource")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@CIWrapping
	public SimpleMessage failWithAutolinkCIError() throws WebApplicationException;
}