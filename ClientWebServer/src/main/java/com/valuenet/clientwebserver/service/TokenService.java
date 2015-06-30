package com.valuenet.clientwebserver.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.valuenet.clientwebserver.model.Usuario;
import com.valuenet.clientwebserver.model.auth.Criptografia;

/*******************************************************************************
*                          Copyright (C) 2015 ValueNET
* ------------------------------------------------------------------------------
* Author: MMB                       date: 22/06/2015
* 
* Name: TokenService.java
* 
*******************************************************************************/
public class TokenService implements Serializable {

	private static final long serialVersionUID = -5923036547096674201L;
	
	private static final String ARQUIVO_CVS = "../client_server_token.csv";
	
	private static String encriptar(String password){
		return Criptografia.sha_256(password);
	}

	/**
	 * Metodo statico que verifica existencia de usuario
	 * @param username
	 * @param password
	 * @return true se existe ou false se nao existe
	 */
	public static boolean isUser(String username, String password) {

		BufferedReader bufferedReader = null;
		String linha = "";
		String csvDivisor = ",";

		try {
			File f = new File(ARQUIVO_CVS);
			if (!f.exists()) {
				System.out.println("Arquivo token não foi encontrado.");
				gravarToken(username, password, true);
			}

			bufferedReader = new BufferedReader(new FileReader(ARQUIVO_CVS));

			String passwordEncript = encriptar(password);

			while ((linha = bufferedReader.readLine()) != null) {
				String[] token = linha.split(csvDivisor);
				if (token.length != 2)
					continue;
				if (username.equals(token[0])
						&& passwordEncript.equals(token[1]))
					return true;
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

		return false;
	}

	/**
	 * O parametro encriptar é necessario, pois ele é usado no metodo 
	 * remover.
	 * 
	 * @param username
	 * @param password
	 * @param encriptar (true para criptografar, false para nao criptografar)
	 * @return boolean
	 */
	public static boolean gravarToken(String username, String password, boolean encriptar) {

		BufferedWriter bWriter = null;

		try {
			bWriter = new BufferedWriter(new FileWriter(ARQUIVO_CVS, true));
			if(encriptar){
				bWriter.write(username + "," + encriptar(password));
			}else{
				bWriter.write(username + "," + password);
			}
			bWriter.newLine();
			bWriter.flush();
			bWriter.close();

			return true;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.toString());
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public static List<Usuario> remover(String username) {
		List<Usuario> listUser = usuarios();
		List<Usuario> listUserNew = new ArrayList<>();
		File f = new File(ARQUIVO_CVS);
		f.delete();
		
		for(Usuario u : listUser){
			if(!u.getUsername().equals(username)){
				gravarToken(u.getUsername(), u.getPassword(), false);
				listUserNew.add(u);
			}
		}
		return listUserNew;
	}

	public static List<Usuario> usuarios() {
		List<Usuario> listUsuarios = new ArrayList<>();

		BufferedReader bufferedReader = null;
		String linha = "";
		String csvDivisor = ",";

		try {
			File f = new File(ARQUIVO_CVS);
			if (!f.exists()) {
				System.out.println("Arquivo token não foi encontrado.");
			}

			bufferedReader = new BufferedReader(new FileReader(ARQUIVO_CVS));

			while ((linha = bufferedReader.readLine()) != null) {
				String[] token = linha.split(csvDivisor);
				if (token.length != 2)
					continue;
				listUsuarios.add(new Usuario(token[0], token[1]));
			}

			return listUsuarios;

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

		return listUsuarios = null;
	}

}
