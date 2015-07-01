package com.valuenet.clientwebserver.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.valuenet.clientwebserver.model.Usuario;
import com.valuenet.clientwebserver.service.UsuarioService;
import com.valuenet.clientwebserver.util.FacesUtil;

/*******************************************************************************
*                          Copyright (C) 2015 ValueNET
* ------------------------------------------------------------------------------
* Author: MMB                       date: 26/06/2015
* 
* Name: UsuarioBean.java
* 
*******************************************************************************/
@Named
@SessionScoped
public class UsuarioBean implements Serializable{

	private static final long serialVersionUID = 7133400436136653035L;
	
	private static final boolean EXCLUIR = false;
	private String username;
	private String password;
	@Inject
	private UsuarioService usuarioService;
	private Usuario usuarioSelecionado;
	private List<Usuario> listUsuario;
	Usuario u;
	
	@PostConstruct
	public void init(){
		// TODO Se a view ja foi inicializada nao vai entrar
		if (FacesUtil.isNotPostBack()) {
			limpar();
			usuarios();
		}
	}
	
	public void salvar() {
		if(usuarioService.salvar(username, password)){
			FacesUtil.addInfoMessage("Salvo com sucesso.");
			limpar();
			usuarios();
		}else{
			FacesUtil.addErrorMessage("Usuário já cadastrado.");
		}
	}
	
	public void usuarios(){
		this.listUsuario =  usuarioService.usuarios();
	}
	
	public void remover(){
		if(usuarioService.isUser(usuarioSelecionado.getUsername(), usuarioSelecionado.getPassword(), EXCLUIR)){
			this.listUsuario = usuarioService.remover(usuarioSelecionado.getUsername());
		}else{
			FacesUtil.addErrorMessage("Usuário não encontrado na base.");
		}
	}
	
	public void limpar(){
		username = null;
		password = null;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Usuario> getListUsuario() {
		return listUsuario;
	}

	public void setListUsuario(List<Usuario> listUsuario) {
		this.listUsuario = listUsuario;
	}

	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}  
	
}
