package com.valuenet.clientwebserver.service;


public class AcionaDado implements Acionador {

	@Override
	public void acionar(String btParam) {
		System.out.println("Acionador de "+btParam);
		
		String url = "http://192.168.0.159:8080/clientwebserver/xmlServletPath";
		
		ClientHTTP.sendPost(url, btParam);
	}

}
