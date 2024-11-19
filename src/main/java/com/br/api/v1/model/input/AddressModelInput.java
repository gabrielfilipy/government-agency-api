package com.br.api.v1.model.input;

import com.br.api.v1.model.CityModel;
import lombok.*;

@Getter
@Setter
public class AddressModelInput {

    private String cep;
    private CityModel city;

}
