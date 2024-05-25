package com.br.domain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.domain.model.Cidade;
import com.br.domain.model.Endereco;
import com.br.domain.model.Estado;
import com.br.domain.repository.EstadoRepository;
import com.br.domain.service.EstadoService;

@Service
public class EstadoServiceImpl implements EstadoService{

	@Autowired
	private EstadoRepository estadoRepository;
	
	@Override
	public List<Estado> findAll() {
		return estadoRepository.findAll();
	}

	@Override
	public Estado salvar(Estado estado) {
		Estado cadastrar = estadoRepository.save(estado);
		return cadastrar;
	}

	@Override
	public Estado findById(Long id) {
		Optional<Estado> buscar = estadoRepository.findById(id);
		return buscar.get();
	}
}
