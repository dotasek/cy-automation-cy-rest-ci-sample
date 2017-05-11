package org.cytoscape.cyrestcisample.internal;


import org.osgi.framework.BundleContext;
import java.util.Properties;

import org.cytoscape.ci.CIErrorFactory;
import org.cytoscape.ci.CIExceptionFactory;
import org.cytoscape.service.util.AbstractCyActivator;

public class CyActivator extends AbstractCyActivator {
	
	public CyActivator() 
	{
		super();
	}
	
	public void start(BundleContext bc) 
	{
		CIExceptionFactory ciExceptionFactory = this.getService(bc, CIExceptionFactory.class);
		CIErrorFactory ciErrorFactory = this.getService(bc, CIErrorFactory.class);
		System.out.println("CyREST Sample start");
		try {
			registerService(bc, new CIResourceImpl(ciExceptionFactory, ciErrorFactory), CIResourceImpl.class, new Properties());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("CyREST Sample registerService complete");
	}
}

