package com.br.domain.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Table(name = "TBL_CIDADE")
@Entity
public class Cidade {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long cidadeId;
	
	@NotBlank(message = "Nao pode ficar em branco")
	@NotNull
	@Column(name = "nome")
	private String nome;
}
