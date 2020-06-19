package com.bns.model;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	
	private final String jwttoken;
	private String userName;
	
	public JwtResponse(String jwttoken, String userName) {
		this.jwttoken = jwttoken;
		this.userName = userName;
	}

	public String getToken() {
		return this.jwttoken;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}