package com.br.domain.model;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@Table(name = "TBL_ENDERECO")
@Entity
public class Endereco {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long enderecoId;
	
	@OneToOne
	@JoinColumn(name = "estado_id")
	private Estado estadoId;
	
	@OneToOne
	@JoinColumn(name = "cidade_id")
	private Cidade cidadeId;
}
