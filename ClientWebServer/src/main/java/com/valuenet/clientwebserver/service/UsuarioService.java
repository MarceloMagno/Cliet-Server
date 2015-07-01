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
	 * Salva novo usuario.
	 * 
	 * @param username
	 * @param password
	 * @return boolean
	 */
	public boolean salvar(String username, String password){
		if(TokenService.isUser(username, password, true))
			return false;
		
		if(TokenService.gravarToken(username, password, true))
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
	
	/**
	 * Verifica existencia de usuario. 
	 * Obs.: Para incluir novo usuario o parametro deve ser true, para excluir o parametro de ser false.
	 * @param username
	 * @param password
	 * @param encriptar
	 * @return true se existe ou false se nao existe
	 */
	public boolean isUser(String username, String password, boolean encriptar){
		return TokenService.isUser(username, password, encriptar);
	}
	
	/**
	 * Exclui o usuario passado por parametro e retorna todos usuarios restante
	 * @param username
	 * @return List<Usuario>
	 */
	public List<Usuario> remover(String username){
		return TokenService.remover(username);
	}

}
