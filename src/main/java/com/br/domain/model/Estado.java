package com.br.domain.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Table(name = "ESTADO")
@Entity
public class Estado {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@NotNull
	@Column(name = "nome")
	private String nome;
}
