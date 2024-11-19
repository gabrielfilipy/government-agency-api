package com.br.api.v1.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.api.v1.model.input.AddressModelInput;
import com.br.domain.model.Address;

@Component
public class AddressModelMapperBack {

	@Autowired
	private ModelMapper modelMapper;

	public Address toModel(AddressModelInput addressModelInput) {
		Address address =
				modelMapper.map(addressModelInput, Address.class);
		return address;
	}
}
