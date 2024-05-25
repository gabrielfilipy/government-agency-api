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
	
	@NotBlank(message = "Nao pode ficar em branco")
	@NotNull
	@Column(name = "nome")
	private String nome;
	
	private boolean active;
	
	@ManyToOne
	@JoinColumn(name = "endereco_id")
	private Endereco enderecoId;
}
