package com.br.domain.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Table(name = "TBL_ORGAO")
@Entity
public class Orgao implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long orgaoId;

	@NotNull
	@Column(name = "nome")
	private String nome;

	private boolean active;

	@Embedded
	private Endereco endereco;
}
