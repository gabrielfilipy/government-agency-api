package com.br.api.v1.model.input;

import javax.validation.constraints.*;
import lombok.*;

@Getter
@Setter
public class CityModelInput {

    // private UUID id;


	@NotBlank
	@NotNull
	private String name;

	@NotBlank
	@NotNull
	private StateModelInput state;
}
