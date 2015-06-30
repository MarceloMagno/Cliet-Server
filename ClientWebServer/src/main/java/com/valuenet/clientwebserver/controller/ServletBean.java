package com.valuenet.clientwebserver.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.valuenet.clientwebserver.model.Servlet;
import com.valuenet.clientwebserver.service.ServletService;
import com.valuenet.clientwebserver.service.URL;
import com.valuenet.clientwebserver.util.FacesUtil;

/*******************************************************************************
*                          Copyright (C) 2015 ValueNET
* ------------------------------------------------------------------------------
* Author: MMB                       date: 26/06/2015
* 
* Name: ServletBean.java
* 
*******************************************************************************/
@Named
@RequestScoped
public class ServletBean implements Serializable{

	private static final long serialVersionUID = 7133400436136653035L;
	
	private String ip;
	private String porta;
	private String nome;
	private Servlet servlet;
	private boolean selectCheckbox;
	private boolean habilitar;
	private String url;
	
	@PostConstruct
	public void init(){
		//TODO Se a view ja foi inicializada nao vai entrar
		if (FacesUtil.isNotPostBack()) {
			servlet();
			selectCheckbox = false;
			habilitarCamposDaForm();
		}
		
	}
	
	public void salvar() {
		if(ServletService.salvar(new Servlet(ip, porta, nome))){
			selectCheckbox = false;
			habilitarCamposDaForm();
			FacesUtil.addInfoMessage("Salvo com sucesso.");
		}else{
			FacesUtil.addErrorMessage("Erro ao tenta salvar.");
		}
	}
	
	public void cancelarEdicao(){
		servlet();
		selectCheckbox = false;
		habilitarCamposDaForm();
	}
	
	public void servlet(){
		if((servlet =  ServletService.getServlet()) != null){
			this.ip = servlet.getIp();
			this.porta = servlet.getPorta();
			this.nome = servlet.getNomeServlet();
			this.url = URL.getURL();
		}else{
			this.ip = null;
			this.porta = null;
			this.nome = null;
			FacesUtil.addErrorMessage("Nenhum Servlet cadastrado.");
		}
	}
	
	public void habilitarCamposDaForm(){
		habilitar = selectCheckbox ? false : true;
		servlet();
	}
	
	public Servlet getServlet() {
		return servlet;
	}

	public void setServlet(Servlet servlet) {
		this.servlet = servlet;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPorta() {
		return porta;
	}

	public void setPorta(String porta) {
		this.porta = porta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isHabilitar() {
		return habilitar;
	}

	public void setHabilitar(boolean habilitar) {
		this.habilitar = habilitar;
	}

	public boolean isSelectCheckbox() {
		return selectCheckbox;
	}

	public void setSelectCheckbox(boolean selectCheckbox) {
		this.selectCheckbox = selectCheckbox;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
