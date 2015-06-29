package com.valuenet.clientwebserver.model.auth;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*******************************************************************************
*                          Copyright (C) 2015 ValueNET
* ------------------------------------------------------------------------------
* Author: MMB                       date: 22/06/2015
* 
* Name: Criptografia.java
* 
* Classe responsavel por encriptar os password. Algoritmos MD5 e SHA-256
*******************************************************************************/
public class Criptografia {

	private static final String SHA_256 = "SHA-256";
	private static final String MD5 = "MD5";
	
	public static String sha_256(String password){
		return encriptar(password, SHA_256);
	}
	
	public static String md5(String password){
		return encriptar(password, MD5);
	}
	
	private static String encriptar(String password, String algoritmo){
		MessageDigest algorithm;
		StringBuilder hexStringSenhaAdmin = new StringBuilder();

		try {
			algorithm = MessageDigest.getInstance(algoritmo);
			byte messageDigestSenhaAdmin[] = algorithm.digest(password.getBytes("UTF-8"));
			
			for (byte b : messageDigestSenhaAdmin) {
				hexStringSenhaAdmin.append(String.format("%02X", 0xFF & b));
			}
			
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return hexStringSenhaAdmin.toString();
	}
	

}