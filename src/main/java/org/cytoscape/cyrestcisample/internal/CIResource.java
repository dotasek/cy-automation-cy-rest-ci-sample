package org.cytoscape.cyrestcisample.internal;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import org.cytoscape.ci.CISwaggerConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Extension;
import io.swagger.annotations.ExtensionProperty;

@Api
@Path("/wrappedgreeting")
public interface CIResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
	@ApiOperation (
			value="Say Hello", 
			extensions = { 
		       @Extension(name = CISwaggerConstants.CI_EXTENSION, properties = { @ExtensionProperty(name=CISwaggerConstants.CI_EXTENSION_CI_WRAPPING, value=CISwaggerConstants.TRUE)})}
		)
    public SimpleMessage success();
    
    @Path("/fail")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	@ApiOperation (
			value="Fails", 
			extensions = { 
		       @Extension(name = CISwaggerConstants.CI_EXTENSION, properties = { @ExtensionProperty(name=CISwaggerConstants.CI_EXTENSION_CI_WRAPPING, value=CISwaggerConstants.TRUE)})}
		)
    public SimpleMessage fail() throws Exception;
    
    @Path("/failwithresource")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation (
			value="Fails with a CIError.", 
			extensions = { 
		       @Extension(name = CISwaggerConstants.CI_EXTENSION, properties = { @ExtensionProperty(name=CISwaggerConstants.CI_EXTENSION_CI_WRAPPING, value=CISwaggerConstants.TRUE)})}
		)
	public SimpleMessage failWithCIError() throws WebApplicationException;
    
    @Path("/failwithautolinkresource")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation (
			value="Fails with an automatically generated CI Error.", 
			extensions = { 
		       @Extension(name = CISwaggerConstants.CI_EXTENSION, properties = { @ExtensionProperty(name=CISwaggerConstants.CI_EXTENSION_CI_WRAPPING, value=CISwaggerConstants.TRUE)})}
		)
	public SimpleMessage failWithAutolinkCIError() throws WebApplicationException;
}