package com.valuenet.clientwebserver.model.auth;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.valuenet.clientwebserver.service.TokenService;

/*******************************************************************************
*                          Copyright (C) 2015 ValueNET
* ------------------------------------------------------------------------------
* Author: MMB                       date: 22/06/2015
* 
* Name: CustomAuthenticationProvider.java
* 
* Classe provedor de autenticacao
*******************************************************************************/
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {

		String username = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();
		
		if (username == null)
			throw new UsernameNotFoundException("Usuário em branco!");
		
		if (password == null)
			throw new UsernameNotFoundException("Senha em branco!");

		if(!TokenService.isUser(username, password))
			throw new UsernameNotFoundException("Usuário não encontrado!");
		
		Authentication customAuthentication = new CustomUserAuthentication(
				"ADMINISTRADOR", authentication);
		
		customAuthentication.setAuthenticated(true);

		return customAuthentication;
	}

	@Override
	public boolean supports(Class<? extends Object> authentication) {
		return UsernamePasswordAuthenticationToken.class
				.isAssignableFrom(authentication);
	}

}
