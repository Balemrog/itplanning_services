package com.timetech.itplanning_services.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class StudentCreationDto {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotNull
    private String modality;

    @NotNull
    private SchoolClassDto schoolClass;

    @NotNull
    private FormationDto formation;
}
