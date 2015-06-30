package com.valuenet.clientwebserver.util;

import java.io.Serializable;

import com.valuenet.clientwebserver.model.Servlet;
import com.valuenet.clientwebserver.service.ServletService;

/*******************************************************************************
*                          Copyright (C) 2015 ValueNET
* ------------------------------------------------------------------------------
* Author: MMB                       date: 29/06/2015
* 
* Name: URL_Util.java
* 
*******************************************************************************/
public class URL_Util implements Serializable{

	private static final long serialVersionUID = -8119736676246929348L;

	public static String getURL() {
		Servlet servlet = null;

		if ((servlet = ServletService.getServlet()) != null) {
			return "http://" + servlet.getIp() + ":" + servlet.getPorta()
					+ "/clientwebserver/" + servlet.getNomeServlet();
		}

		return null;
	}
}
