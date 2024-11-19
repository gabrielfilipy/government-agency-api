package com.br.api.v1.model.input;

import lombok.*;

import javax.validation.constraints.*;
import java.util.UUID;

@Getter
@Setter
public class CityModelInput {

    @NotBlank
    @NotNull
    private UUID id;

}
