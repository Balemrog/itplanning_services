package com.timetech.itplanning_services.dto;

public class RoomDto {

    private String material;

    private String roomName;

    private String building;

    public RoomDto(String material, String roomName, String building) {
        this.material = material;
        this.roomName = roomName;
        this.building = building;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }
}
