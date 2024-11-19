package com.br.api.v1.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class AddressModel {

    private String cep;
    private CityModel city;

}
