package com.br.api.v1.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class StateModel {

    private UUID id;
    private String name;

}
