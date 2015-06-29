package com.valuenet.clientwebserver.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

import com.valuenet.clientwebserver.model.Servlet;

/*******************************************************************************
 * Copyright (C) 2015 ValueNET
 * --------------------------------------------------
 * ---------------------------- Author: MMB date: 22/06/2015
 * 
 * Name: ServletRepository.java
 * 
 *******************************************************************************/
public class ServletRepository implements Serializable {

	private static final long serialVersionUID = 6264447356318421563L;

	private static final String ARQUIVO_CVS = "../servlet.csv";

	public static boolean salvar(final Servlet servlet){
		
		BufferedWriter bWriter = null;
		
		try{
			bWriter = new BufferedWriter( new FileWriter(ARQUIVO_CVS));
			bWriter.write(servlet.getIp()+","+servlet.getPorta()+","+servlet.getNomeServlet()); 
        	
			bWriter.flush();
        	bWriter.close();
        	
			return true;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
	        System.out.println(e.toString());
	    } catch (IOException e) {
	        e.printStackTrace(); 
	        System.out.println(e.toString());
	    } 
		catch (Exception e) {
	        e.printStackTrace();
	    }
		
		return false;
	}
	
	public static Servlet getServlet() {
		BufferedReader bufferedReader = null;
		String linha = "";
		String csvDivisor = ",";

		try {
			/*
			 * File f = new File(ARQUIVO_CVS); if(!f.exists()){
			 * System.out.println("Arquivo token não foi encontrado.");
			 * gravarToken(username, password); }
			 */

			bufferedReader = new BufferedReader(new FileReader(ARQUIVO_CVS));

			while ((linha = bufferedReader.readLine()) != null) {
				String[] token = linha.split(csvDivisor);
				if (token.length != 3) continue;

				return new Servlet(token[0], token[1], token[2]);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.toString());
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.toString());
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println(e.toString());
				}
			}
		}

		return null;
	}

}
