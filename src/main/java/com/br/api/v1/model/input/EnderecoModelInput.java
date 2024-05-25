package com.br.api.v1.model.input;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoModelInput {
	@NotNull
    private Long estadoId;
    
    @NotNull
    private Long cidadeId;
}
