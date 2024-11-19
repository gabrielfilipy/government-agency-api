package com.br.api.exceptionhandler.exceptions;

public class BusinessRoleExceptionException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public BusinessRoleExceptionException(String message) {
		super(message);
	}
	
	public BusinessRoleExceptionException(String messsage, Throwable cases) {
		super(messsage, cases);
	}

}
