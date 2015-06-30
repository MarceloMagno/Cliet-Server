package com.valuenet.clientwebserver.service;

/*******************************************************************************
*                          Copyright (C) 2015 ValueNET
* ------------------------------------------------------------------------------
* Author: MMB                       date: 26/06/2015
* 
* Name: AcionadorDado.java
* 
*******************************************************************************/
public class AcionadorDado implements Acionador {

	@Override
	public boolean acionar(String btParam) {
		String url = null;
		
		if( (url = URL.getURL()) != null){
			return ClientHTTP.sendPost(url, btParam);
		}
		
		return false;
	}

}
