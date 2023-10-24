package com.timetech.itplanning_services.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Public.class)
    private int id;

    @NotNull
    @JsonView(Views.Public.class)
    private String material;

    @NotNull
    @JsonView(Views.Public.class)
    private String roomName;

    @NotNull
    @JsonView(Views.Public.class)
    private String building;

    //    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    //    @JsonManagedReference
    //    @JsonBackReference

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional=false)
    @JoinColumn(name="campus_id", referencedColumnName="id", nullable=false)
    @JsonView(Views.Public.class)
    private Campus campus;

    public Room() {
    }

    public Room(String material, String roomName, String building) {
        this.material = material;
        this.roomName = roomName;
        this.building = building;
    }

    public Room(String material, String roomName, String building, Campus campus) {
        this.material = material;
        this.roomName = roomName;
        this.building = building;
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

//    @JsonIgnore
    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", material='" + material + '\'' +
                ", roomName='" + roomName + '\'' +
                ", building='" + building + '\'' +
                ", campus=" + campus +
                '}';
    }
}
