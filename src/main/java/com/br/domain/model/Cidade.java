package com.br.domain.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Table(name = "CIDADE")
@Entity
public class Cidade {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@NotNull
	private String nome;
	
	@ManyToOne
	private Estado estado;
}
