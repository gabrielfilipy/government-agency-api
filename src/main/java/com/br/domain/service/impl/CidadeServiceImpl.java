package com.br.domain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.domain.model.Cidade;
import com.br.domain.model.Estado;
import com.br.domain.repository.CidadeRepository;
import com.br.domain.service.CidadeService;

@Service
public class CidadeServiceImpl implements CidadeService{

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Override
	public List<Cidade> findAll() {
		return cidadeRepository.findAll();
	}

	@Override
	public Cidade salvar(Cidade cidade) {
		Cidade cadastrar = cidadeRepository.save(cidade);
		return cadastrar;
	}

	@Override
	public Cidade findById(Long id) {
		Optional<Cidade> buscar = cidadeRepository.findById(id);
		return buscar.get();
	}
}
