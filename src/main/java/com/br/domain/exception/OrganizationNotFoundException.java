package com.br.domain.exception;

import com.br.api.exceptionhandler.exceptions.NotFoundException;

import java.util.UUID;

public class OrganizationNotFoundException extends NotFoundException {

	private static final long serialVersionUID = 1L;

	public OrganizationNotFoundException(String mensagem) {
		super(mensagem);
	}

	public OrganizationNotFoundException(UUID id) {
		super(String.format("Não existe um Órgão com código %s", id));
	}

}
