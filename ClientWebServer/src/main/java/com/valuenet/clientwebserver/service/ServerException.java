package com.valuenet.clientwebserver.service;

/*******************************************************************************
*                          Copyright (C) 2015 ValueNET
* ------------------------------------------------------------------------------
* Author: MMB                       date: 26/06/2015
* 
* Name: ServerException.java
* 
*******************************************************************************/
public class ServerException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ServerException(String msg) {
		super(msg);
	}
	
}
