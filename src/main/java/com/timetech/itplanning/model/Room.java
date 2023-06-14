package com.timetech.itplanning.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    @Size(max=100)
    private String material;

    @NotBlank
    @Size(max=100)
    private String className;

    @NotBlank
    @Size(max=100)
    private String roomName;

    @NotNull
    @ManyToOne
    private Campus campus;

    public Room() {
    }

    public Room(int id, String material, String className, String roomName, Campus campus) {
        this.id = id;
        this.material = material;
        this.className = className;
        this.roomName = roomName;
        this.campus = campus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }
}
