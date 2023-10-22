package com.timetech.itplanning_services.dto;

public class RoomDto {

    private String material;

    private String className;

    private String roomName;

    private String building;

    public RoomDto(String material, String className, String roomName, String building) {
        this.material = material;
        this.className = className;
        this.roomName = roomName;
        this.building = building;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
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
