package com.valuenet.clientwebserver.model;

/*******************************************************************************
*                          Copyright (C) 2015 ValueNET
* ------------------------------------------------------------------------------
* Author: MMB                       date: 26/06/2015
* 
* Name: Servlet.java
* 
*******************************************************************************/
public class Servlet {

	private String ip;
	private String porta;
	private String nomeServlet;

	public Servlet(String ip, String porta, String nomeServlet) {
		super();
		this.ip = ip;
		this.porta = porta;
		this.nomeServlet = nomeServlet;
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

	public String getNomeServlet() {
		return nomeServlet;
	}

	public void setNomeServlet(String nomeServlet) {
		this.nomeServlet = nomeServlet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ip == null) ? 0 : ip.hashCode());
		result = prime * result
				+ ((nomeServlet == null) ? 0 : nomeServlet.hashCode());
		result = prime * result + ((porta == null) ? 0 : porta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servlet other = (Servlet) obj;
		if (ip == null) {
			if (other.ip != null)
				return false;
		} else if (!ip.equals(other.ip))
			return false;
		if (nomeServlet == null) {
			if (other.nomeServlet != null)
				return false;
		} else if (!nomeServlet.equals(other.nomeServlet))
			return false;
		if (porta == null) {
			if (other.porta != null)
				return false;
		} else if (!porta.equals(other.porta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Servlet [ip=" + ip + ", porta=" + porta + ", nomeServlet="
				+ nomeServlet + "]";
	}

}
