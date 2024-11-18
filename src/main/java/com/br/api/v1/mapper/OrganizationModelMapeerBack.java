package com.br.api.v1.mapper;
import com.br.api.v1.model.input.OrgaoActiveModelInput;
import com.br.api.v1.model.input.OrgaoModelInput;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.br.domain.model.Orgao;

@Component
public class OrganizationModelMapeerBack {

	@Autowired
	private ModelMapper modelMapper;

	public Orgao toModel(OrgaoModelInput orgaoModelInput) {
		Orgao orgao =
				modelMapper.map(orgaoModelInput, Orgao.class);
		return orgao;
	}
	
	public Orgao toModel(OrgaoActiveModelInput orgaoActiveModelInput) {
		Orgao orgao =
				modelMapper.map(orgaoActiveModelInput, Orgao.class);
		return orgao;
	}

}
