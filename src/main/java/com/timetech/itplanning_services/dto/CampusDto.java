package com.timetech.itplanning_services.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CampusDto {

    @Id
    @NotNull
    private int id;

    @NotBlank
    private String location;

}
