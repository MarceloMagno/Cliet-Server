package com.valuenet.clientwebserver.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.validator.internal.util.privilegedactions.GetMethod;

import com.valuenet.clientwebserver.service.Acionador;
import com.valuenet.clientwebserver.service.QualificadorDados;
import com.valuenet.clientwebserver.service.QualificadorEstrutura;

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
		acionador.acionar("Estrutura");
		
	}
	
	@QualificadorDados
	public void dados(){
		acionador.acionar("Dados");
	}
}
