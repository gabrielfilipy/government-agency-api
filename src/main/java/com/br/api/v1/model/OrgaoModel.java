package com.br.api.v1.model;

import java.util.UUID;

import com.br.api.v1.model.input.EnderecoModelInput;
import com.br.domain.model.Endereco;
import lombok.Data;

@Data
public class OrgaoModel {

	private UUID orgaoId;
	private String nome;
	private boolean active;
	private EnderecoModelInput endereco;
}