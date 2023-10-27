package com.timetech.itplanning_services.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Getter
@Setter
public class TeacherCreationDto {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotNull
    private Boolean isEmployee;

    @NotNull
    private List<String> lessons;
}
