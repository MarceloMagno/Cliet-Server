package com.valuenet.clientwebserver.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/*******************************************************************************
*                          Copyright (C) 2015 ValueNET
* ------------------------------------------------------------------------------
* Author: MMB                       date: 26/06/2015
* 
* Name: ClientHTTP.java
* 
*******************************************************************************/
public class ClientHTTP {

	private static final String USER_AGENT = "Mozilla/5.0";
	
	/**
	 * HTTP GET request
	 * @param param nome do arquivo a ser execultado
	 * @return true se sucesso, false se erro
	 * @throws Exception
	 */
	public static boolean sendGet(String btParam) throws Exception {
 
		String url = "http://192.168.0.159:8080/clientwebserver/xmlServletPath?bat="+btParam;
 
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
		// optional default is GET
		con.setRequestMethod("GET");
 
		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);
 
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		System.out.println(response.toString());
 
		return false;
	}
 
	// HTTP POST request http://localhost:8080/clientwebserver/xmlServletPath?bat=desktop
	/**
	 * HTTP POST request
	 * @param param nome do arquivo a ser execultado
	 * @return true se sucesso, false se erro
	 * @throws Exception
	 */
	public static boolean sendPost(String url, String btParam) {
		//String url = "http://192.168.0.159:8080/clientwebserver/xmlServletPath";
		
		try {
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			
			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", USER_AGENT);
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
			
			String urlParameters = "bat="+btParam;
			
			// Executa post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();
			
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Post parameters : " + urlParameters);
			System.out.println("Response Code : " + responseCode);
			
			BufferedReader in = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			//print result
			System.out.println(response.toString());
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
 
		return false;
	}
		
}
