package com.br.api.v1.model.input;

import com.br.domain.model.Endereco;
import lombok.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class OrgaoModelInput {
	
	@NotBlank
	@NotNull
	private String nome;

	private boolean active;

	@NotNull
	private Endereco endereco;

}
