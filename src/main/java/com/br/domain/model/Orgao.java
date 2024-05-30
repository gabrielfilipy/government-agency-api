package com.br.domain.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Table(name = "ORGAO")
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
	@Column(name = "endereco")
	private Endereco endereco;
}
