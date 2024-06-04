package com.br.api.v1.model;

import com.br.api.v1.model.input.EnderecoModelInput;
import com.br.domain.model.Endereco;
import lombok.Data;

@Data
public class OrgaoModel {

	private Long orgaoId;
	private String nome;
	private boolean active;
	private EnderecoModelInput endereco;
}