package com.br.domain.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Table(name = "TBL_ESTADO")
@Entity
public class Estado {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long estadoId;
	
	@NotBlank(message = "Nao pode ficar em branco")
	@NotNull
	@Column(name = "nome")
	private String nome;
}
