package com.valuenet.clientwebserver.service;


@QualificadorEstrutura
public class AcionaEstrutura implements Acionador{

	@Override
	public void acionar(String btParam) {
		System.out.println("Acionador de "+btParam);
		
		String url = "http://192.168.0.159:8080/clientwebserver/xmlServletPath";
		
		ClientHTTP.sendPost(url, btParam);
	}

}
