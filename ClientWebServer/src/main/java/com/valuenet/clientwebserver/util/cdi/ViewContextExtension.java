package com.valuenet.clientwebserver.util.cdi;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterBeanDiscovery;
import javax.enterprise.inject.spi.BeforeBeanDiscovery;
import javax.enterprise.inject.spi.Extension;
import javax.faces.bean.ViewScoped;

/*******************************************************************************
*                          Copyright (C) 2015 ValueNET
* ------------------------------------------------------------------------------
* Author: MMB                       date: 22/06/2015
* 
* Name: ViewContextExtension.java
* 
*******************************************************************************/
public class ViewContextExtension implements Extension {
	
	public void addScope(@Observes final BeforeBeanDiscovery event)
	{
		event.addScope(ViewScoped.class, true, true);
	}

	public void registerContext(@Observes final AfterBeanDiscovery event)
	{
		event.addContext(new ViewScopedContext());
	}
}