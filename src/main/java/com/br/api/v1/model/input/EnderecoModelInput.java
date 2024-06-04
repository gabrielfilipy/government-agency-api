package com.br.api.v1.model.input;

import com.br.api.v1.model.CidadeModel;
import lombok.Data;

import java.io.Serializable;

@Data
public class EnderecoModelInput {

    private String cep;

    private CidadeModel cidade;
}
