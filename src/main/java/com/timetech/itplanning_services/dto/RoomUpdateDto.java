package com.timetech.itplanning_services.dto;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomUpdateDto {

    @Id
    @NotNull
    private int id;

    @NotBlank
    private String material;

    @NotBlank
    private String roomName;

    @NotBlank
    private String building;

    @NotNull
    private CampusDto campus;
}
