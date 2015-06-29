package com.valuenet.clientwebserver.service;


@QualificadorEstrutura
public class AcionaEstrutura implements Acionador{

	@Override
	public void acionar(String btParam) {
		System.out.println("Acionador de "+btParam);
	}

}
