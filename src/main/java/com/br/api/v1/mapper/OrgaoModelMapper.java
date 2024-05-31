package com.br.api.v1.mapper;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.br.api.v1.model.OrgaoModel;
import com.br.api.v1.model.input.OrgaoModelInput;
import com.br.domain.model.Orgao;

@Component
public class OrgaoModelMapper {
	@Autowired
	private ModelMapper modelMapper;
	
	public OrgaoModel toModel(Orgao orgao) {
		OrgaoModel orgaoModel =
				modelMapper.map(orgao, OrgaoModel.class);
		return orgaoModel;
	}
	

}
