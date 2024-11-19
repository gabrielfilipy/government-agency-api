package com.br.api.v1.mapper;

import com.br.domain.model.Organization;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.br.api.v1.model.OrganizationModel;

@Component
public class OrganizationModelMapper {

	@Autowired
	private ModelMapper modelMapper;
	
	public OrganizationModel toModel(Organization organization) {
		return modelMapper.map(organization, OrganizationModel.class);
	}

}
