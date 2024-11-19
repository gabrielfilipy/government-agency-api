package com.br.api.v1.mapper;

import com.br.api.v1.model.input.*;
import com.br.domain.model.Organization;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrganizationModelMapeerBack {

	@Autowired
	private ModelMapper modelMapper;

	public Organization toModel(OrganizationModelInput organizationModelInput) {
		return modelMapper.map(organizationModelInput, Organization.class);
	}

}
