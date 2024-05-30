package com.br.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.*;

@Data
@Embeddable
public class Endereco {
	
	@NotNull
	private String cep;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "endereco_cidade_id")
	private Cidade cidade;
}
