package com.br.api.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class CityModel {

    private UUID id;
    private String name;
    private StateModel state;

}
