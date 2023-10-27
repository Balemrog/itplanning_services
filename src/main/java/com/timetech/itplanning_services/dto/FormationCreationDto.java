package com.timetech.itplanning_services.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormationCreationDto {

    @NotBlank
    private String label;

}
