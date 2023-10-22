package com.timetech.itplanning_services.dto;

public class CampusDto {

    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public CampusDto(String location) {
        this.location = location;
    }
}
