package com.br.domain.model;

import java.util.UUID;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Table(name = "TBL_ESTADO")
@Entity
public class Estado {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private UUID estadoId;
	
	@NotBlank(message = "Nao pode ficar em branco")
	@NotNull
	@Column(name = "nome")
	private String nome;
}
