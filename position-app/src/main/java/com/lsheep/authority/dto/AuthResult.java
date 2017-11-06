package com.lsheep.authority.dto;

public class AuthResult {

	private String customerId;
	private AuthStatus status;
	private String message;
	private String redirect;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public AuthStatus getStatus() {
		return status;
	}

	public void setStatus(AuthStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRedirect() {
		return redirect;
	}

	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}

}
