package com.valuenet.clientwebserver.webserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*******************************************************************************
*                          Copyright (C) 2015 ValueNET
* ------------------------------------------------------------------------------
* Author: RCS/MMB                      date: 22/06/2015
* 
* Name: XmlServlet.java
* 
*******************************************************************************/
public class XmlServlet extends HttpServlet {

	private static final long serialVersionUID = -4600587482671529523L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		Properties diretorios = getPropertiesDiretorios();

		try {
			String saida = executaArquivoBat(request.getParameter("bat"),
					diretorios);
			if (saida != null) {
				out.println("Olá do GET \n" + saida);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private Properties getPropertiesDiretorios() {
		Properties prop = new Properties();
		InputStream input = null;
		String filename = "diretorios.properties";

		try {

			input = getServletContext().getResourceAsStream(filename);
			if (input == null) {
				System.out.println("o arquivo  " + filename
						+ " não pode ser encontrado");
				return null;
			}

			// carrega o arquivo de propriedades do classpath
			prop.load(input);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop;

	}

	private String executaArquivoBat(String arquivoBatNome, Properties properDir)
			throws Exception {
		String arquivoBat = arquivoBatNome;

		String reposta = null;

		try {
			if (arquivoBat != null && !arquivoBat.equals("")) {
				String caminhoBat = null;

				if (arquivoBat.equals("desktop")) {
					caminhoBat = "cmd.exe /c "
							+ properDir.getProperty("DIRETORIO_DESKTOP");
					reposta = "Foi executado o arquivo desktop.bat localizado em "
							+ properDir.getProperty("DIRETORIO_DESKTOP");
				} else if (arquivoBat.equals("tomcat")) {
					caminhoBat = "cmd.exe /c  "
							+ properDir.getProperty("DIRETORIO_APACHE");
					reposta = "Foi executado o arquivo apache.bat localizado em "
							+ properDir.getProperty("DIRETORIO_APACHE");
				} else if (arquivoBat.equals("documentos")) {
					caminhoBat = "cmd.exe /c "
							+ properDir.getProperty("DIRETORIO_DOCUMENTOS");
					reposta = "Foi executado o arquivo documentos.bat localizado em "
							+ properDir.getProperty("DIRETORIO_DOCUMENTOS");

				}

				Runtime.getRuntime().exec(caminhoBat);
			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return reposta;
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Properties diretorios = getPropertiesDiretorios();

		try {
			executaArquivoBat(request.getParameter("bat"), diretorios);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
