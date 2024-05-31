package com.br.api.v1.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.api.v1.model.input.EnderecoModelInput;
import com.br.domain.model.Endereco;
import com.br.domain.model.Orgao;

@Component
public class EnderecoModelMapperBack {

	@Autowired
	private ModelMapper modelMapper;

	public Endereco toModel(EnderecoModelInput enderecoModelInput) {
		Endereco endereco =
				modelMapper.map(enderecoModelInput, Endereco.class);
		return endereco;
	}
}
