package com.br.api.v1.model.input;

import lombok.*;
import javax.validation.constraints.*;
import java.util.UUID;

@Getter
@Setter
public class OrganizationModelInput {

	// private UUID id;

	@NotBlank
	@NotNull
	private String name;

	private boolean active;
	
	private AddressModelInput address;

}
