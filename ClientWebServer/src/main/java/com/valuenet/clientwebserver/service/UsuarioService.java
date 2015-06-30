package com.valuenet.clientwebserver.service;

import java.io.Serializable;
import java.util.List;

import com.valuenet.clientwebserver.model.Usuario;

/*******************************************************************************
*                          Copyright (C) 2015 ValueNET
* ------------------------------------------------------------------------------
* Author: MMB                       date: 29/06/2015
* 
* Name: UsuarioService.java
* 
*******************************************************************************/
public class UsuarioService  implements Serializable {

	private static final long serialVersionUID = 461044198587647611L;
	
	/**
	 * Salva novo usuario
	 * 
	 * @param username
	 * @param password
	 * @return Se true usuario salvo, se false usuario ja existe
	 */
	public boolean salvar(String username, String password){
		if(TokenService.isUser(username, password))
			return false;
		
		if(TokenService.gravarToken(username, password))
			return true;
		
		return false;
	}
	
	/**
	 * Recupera todos usuarios cadastrados
	 * 
	 * @return null se nao existir usuario cadastrado
	 */
	public List<Usuario> usuarios(){
		return TokenService.usuarios();
	}

}
