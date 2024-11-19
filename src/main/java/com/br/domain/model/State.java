package com.br.domain.model;

import java.util.UUID;

import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Table(name = "TBL_STATE")
@Entity
public class State {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private UUID id;
	
	@NotBlank(message = "Nao pode ficar em branco")
	@NotNull
	@Column(name = "name")
	private String name;

}
