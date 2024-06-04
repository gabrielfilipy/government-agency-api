package com.br.api.v1.model;

import com.br.domain.model.Estado;
import lombok.Data;

import java.io.Serializable;

@Data
public class CidadeModel{

    private Long id;

    private EstadoModel estado;
}
