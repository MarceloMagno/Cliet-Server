package com.valuenet.clientwebserver.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.valuenet.clientwebserver.model.Usuario;
import com.valuenet.clientwebserver.service.UsuarioService;
import com.valuenet.clientwebserver.util.FacesUtil;

@Named
@RequestScoped
public class UsuarioBean implements Serializable{

	private static final long serialVersionUID = 7133400436136653035L;
	
	private String username;
	private String password;
	@Inject
	private UsuarioService usuarioService;
	private List<Usuario> listUsuario;
	
	@PostConstruct
	public void init(){
		limpar();
		usuarios();
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
		usuarioService = new UsuarioService();
		this.listUsuario =  usuarioService.usuarios();
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
	
	
}
