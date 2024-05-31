package com.br.api.v1.model.input;

import javax.validation.constraints.NotNull;

import com.br.api.v1.model.CidadeModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoModelInput {
	@NotNull
    private String cep;
    
    @NotNull
    private CidadeModel cidade;
}
