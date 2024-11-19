package com.br.domain.model;

import java.util.UUID;

import javax.persistence.*;

import lombok.*;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "TBL_CITY")
@Entity
public class City {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private UUID id;

	@Column(name = "name")
	private String name;

	@ManyToOne
	private State state;

}
