package com.br.api.exceptionhandler.exceptions;

public class EntityUsedException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public EntityUsedException(String mensagem) {
		super(mensagem);
	}

}
