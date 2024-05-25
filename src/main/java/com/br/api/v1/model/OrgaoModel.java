package com.br.api.v1.model;

import com.br.domain.model.Endereco;
import lombok.Data;

@Data
public class OrgaoModel {

	private Long orgaoId;
	private String nome;
	private Endereco endereco;
	private boolean active;
}