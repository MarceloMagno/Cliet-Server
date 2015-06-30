package com.valuenet.clientwebserver.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.valuenet.clientwebserver.service.Acionador;
import com.valuenet.clientwebserver.service.QualificadorDados;
import com.valuenet.clientwebserver.service.QualificadorEstrutura;
import com.valuenet.clientwebserver.util.FacesUtil;
/*******************************************************************************
*                          Copyright (C) 2015 ValueNET
* ------------------------------------------------------------------------------
* Author: MMB                       date: 26/06/2015
* 
* Name: AcaoBean.java
* 
*******************************************************************************/
@Named
@RequestScoped
public class AcaoBean implements Serializable{

	private static final long serialVersionUID = 4615380409579059957L;

	@Inject
	private Acionador acionador;
	
	@PostConstruct
	public void init(){
		
	}
	
	@QualificadorEstrutura
	public void estrutura(){
		if(!acionador.acionar("desktop"))
			msgBotaoNaoConfigurado();
	}
	
	@QualificadorDados
	public void dados(){
		if(!acionador.acionar("documentos"))
			msgBotaoNaoConfigurado();
	}
	
	private void msgBotaoNaoConfigurado(){
		FacesUtil.addInfoMessage("Botão não Configurado.");
	}
}
