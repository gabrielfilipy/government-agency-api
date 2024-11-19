package com.br.api.v1.model;

import lombok.Data;

import java.util.UUID;

@Data
public class CityModel {

    private UUID id;
    private StateModel state;

}
