package com.br.api.v1.model.input;

import com.br.domain.model.Address;
import lombok.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class OrganizationModelInput {
	
	@NotBlank
	@NotNull
	private String name;

	private boolean active;

	@NotNull
	private Address address;

}
