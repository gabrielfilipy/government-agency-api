package com.br.api.v1.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.br.api.v1.model.EnderecoModel;
import com.br.domain.model.Endereco;

@Component
public class EnderecoModelMapper {

	@Autowired
	private ModelMapper modelMapper;
	
	public EnderecoModel toModel(Endereco endereco) {
		EnderecoModel enderecoModel =
				modelMapper.map(endereco, EnderecoModel.class);
		return enderecoModel;
	}
}
