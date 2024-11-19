package com.br.api.v1.model;

import java.util.UUID;

import com.br.api.v1.model.input.AddressModelInput;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class OrganizationModel {

	private UUID id;
	private String name;
	private boolean active;
	private AddressModel address;

}