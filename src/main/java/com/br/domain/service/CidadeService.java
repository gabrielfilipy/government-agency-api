package com.br.domain.service;

import java.util.List;

import com.br.domain.model.Cidade;

public interface CidadeService {

	List<Cidade> findAll();
	Cidade findById(Long id);
	Cidade salvar(Cidade cidade);
}
