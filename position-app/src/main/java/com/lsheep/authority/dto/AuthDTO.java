package com.lsheep.authority.dto;

import javax.servlet.http.Cookie;

public class AuthDTO {

	private Cookie identity;
	private String requestURI;

	public Cookie getIdentity() {
		return identity;
	}

	public void setIdentity(Cookie identity) {
		this.identity = identity;
	}

	public String getRequestURI() {
		return requestURI;
	}

	public void setRequestURI(String requestURI) {
		this.requestURI = requestURI;
	}

}
