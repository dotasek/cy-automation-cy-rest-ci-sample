package org.cytoscape.cyrestcisample.internal;

import java.net.URI;

import javax.ws.rs.WebApplicationException;
import org.cytoscape.ci.CIErrorFactory;
import org.cytoscape.ci.CIExceptionFactory;
import org.cytoscape.ci.CIWrapping;
import org.cytoscape.ci.model.CIError;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.swagger.annotations.Api;

@Api
public class CIResourceImpl implements CIResource
{
	private static final Logger logger = LoggerFactory.getLogger(CIResourceImpl.class);
	
	CIExceptionFactory exceptionFactory;
	CIErrorFactory errorFactory;
	
	public CIResourceImpl(CIExceptionFactory exceptionFactory, CIErrorFactory errorFactory){
		this.exceptionFactory = exceptionFactory;
		this.errorFactory = errorFactory;
	}
	
	@CIWrapping
	public SimpleMessage success()
	{
		return new SimpleMessage("Hello!");
	}

	@CIWrapping
	public SimpleMessage fail() throws Exception {
		throw new Exception("Kaboom.");
	}
	
	@CIWrapping
	public SimpleMessage failWithCIError() throws WebApplicationException {
		CIError ciError = errorFactory.getCIError(500, "urn:cytoscape:ci:ci-wrap-test:v1:fail-with-ci-error:errors:1", "Intentional fail to report with CI Resource.", URI.create("http://www.google.ca"));
		logger.error("failWithCIError");
		throw exceptionFactory.getCIException(500, new CIError[]{ciError});
	}
	
	@CIWrapping
	public SimpleMessage failWithAutolinkCIError() throws WebApplicationException {
		CIError ciError = errorFactory.getCIError(500, "urn:cytoscape:ci:ci-wrap-test:v1:fail-with-ci-error:errors:1", "Intentional fail to report with CI Resource.");
		logger.error("failWithCIError");
		throw exceptionFactory.getCIException(500, new CIError[]{ciError});
	}
}