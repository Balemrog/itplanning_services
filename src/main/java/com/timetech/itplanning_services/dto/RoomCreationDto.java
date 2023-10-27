package com.timetech.itplanning_services.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomCreationDto {

    @NotBlank
    private String material;

    @NotBlank
    private String roomName;

    @NotBlank
    private String building;

    @NotNull
    private CampusDto campus;
}
