package com.br.api.v1.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.br.api.v1.model.AddressModel;
import com.br.domain.model.Address;

@Component
public class AddressModelMapper {

	@Autowired
	private ModelMapper modelMapper;
	
	public AddressModel toModel(Address address) {
		return modelMapper.map(address, AddressModel.class);
	}

}
