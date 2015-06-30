package com.valuenet.clientwebserver.service;

import com.valuenet.clientwebserver.util.URL_Util;

/*******************************************************************************
*                          Copyright (C) 2015 ValueNET
* ------------------------------------------------------------------------------
* Author: MMB                       date: 26/06/2015
* 
* Name: AcionadorEstrutura.java
* 
*******************************************************************************/
@QualificadorEstrutura
public class AcionadorEstrutura implements Acionador{

	@Override
	public boolean acionar(String btParam) {
		String url = null;
		
		if( (url = URL_Util.getURL()) != null){
			return ClientHTTP.sendPost(url, btParam);
		}
		
		return false;
	}

}
