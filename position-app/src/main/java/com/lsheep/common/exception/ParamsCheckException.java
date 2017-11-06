package com.lsheep.common.exception;

public class ParamsCheckException extends RuntimeException {

	private static final long serialVersionUID = 3365613855611162442L;

	public ParamsCheckException() {
		super();
	}

	public ParamsCheckException(String message) {
		super(message);
	}

	public ParamsCheckException(String message, Throwable cause) {
		super(message, cause);
	}

	public ParamsCheckException(Throwable cause) {
		super(cause);
	}

}
