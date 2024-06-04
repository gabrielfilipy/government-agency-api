package com.br.domain.model;

import javax.persistence.*;
import lombok.*;

@Data
@Embeddable
public class Endereco {

	@Column(name = "endereco_cep")
	private String cep;

	@ManyToOne
	@JoinColumn(name = "endereco_cidade_id")
	private Cidade cidade;
}
