package com.br.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.domain.exception.EntidadeNaoExisteException;
import com.br.domain.model.Endereco;
import com.br.domain.repository.EnderecoRepository;
import com.br.domain.service.EnderecoService;

import java.util.List;

@Service
public class EnderecoServiceImpl implements EnderecoService{

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco findById(Long id) {
        return enderecoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Endereço não encontrado com ID: " + id));
    }

    public List<Endereco> findAll() {
        return enderecoRepository.findAll();
    }

    public Endereco salvar(Endereco endereco) {
    	Endereco cadastrar = enderecoRepository.save(endereco);
    	if(cadastrar == null) {
    		throw new EntidadeNaoExisteException("A cidade ou Estado,aparentement ,não existe");
    	}
        return cadastrar;
    }
}
