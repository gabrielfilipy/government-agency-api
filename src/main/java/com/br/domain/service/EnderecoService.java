package com.br.domain.service;

import java.util.List;

import com.br.domain.model.Endereco;

public interface EnderecoService {

	List<Endereco> findAll();
	Endereco findById(Long id);
	Endereco salvar(Endereco endereco);
}
