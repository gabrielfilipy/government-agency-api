package com.br.domain.model;

import javax.persistence.*;
import lombok.*;

@Data
@Embeddable
public class Address {

	@Column(name = "address_cep")
	private String cep;

	@ManyToOne
	@JoinColumn(name = "endereco_city_id")
	private City city;

}
