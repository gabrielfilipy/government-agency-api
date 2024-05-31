package com.br.api.v1.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.br.api.v1.model.input.EnderecoModelInput;
import com.br.domain.model.Endereco;
import lombok.Data;

@Data
public class OrgaoModel {
	
	@NotBlank
	@NotNull
	private String nome;
	
	@NotNull
	private EnderecoModelInput endereco;
	
	private boolean active;
}