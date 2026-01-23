package com.br.api.v1.model.input;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
public class AddressModelInput {

    // private UUID id;

    private String cep;

    private CityModelInput city;

}
