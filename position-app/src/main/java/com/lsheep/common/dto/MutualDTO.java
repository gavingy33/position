package com.lsheep.common.dto;

public class MutualDTO<T> {

	private MutualStatus status = MutualStatus.OK;
	private String redirect;
	private String error;
	private T mutual;

	public MutualStatus getStatus() {
		return status;
	}

	public void setStatus(MutualStatus status) {
		this.status = status;
	}

	public String getRedirect() {
		return redirect;
	}

	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public T getMutual() {
		return mutual;
	}

	public void setMutual(T mutual) {
		this.mutual = mutual;
	}

}
