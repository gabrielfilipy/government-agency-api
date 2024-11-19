package com.br.api.v1.model.input;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
public class StateModelInput {

    @NotBlank
    @NotNull
    private UUID id;

}
