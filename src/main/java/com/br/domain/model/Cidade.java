package com.br.domain.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "TBL_CIDADE")
@Entity
public class Cidade {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long cidadeId;

	@Column(name = "nome")
	private String nome;

	@ManyToOne
	private Estado estado;
}
