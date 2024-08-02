package com.br.api.v1.model;

import com.br.domain.model.Estado;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class CidadeModel{

    private UUID id;

    private EstadoModel estado;
}
