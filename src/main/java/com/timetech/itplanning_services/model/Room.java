package com.timetech.itplanning_services.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @NotBlank
    @Size(max=100)
    private String building;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="campus_id", referencedColumnName="id")
    private Campus campus;

    @OneToOne(mappedBy="room")
    private LessonSession lessonSession;

    public Room() {
    }

    public Room(String material, String className, String roomName, String building) {
        this.material = material;
        this.className = className;
        this.roomName = roomName;
        this.building = building;
    }

    public Room(String material, String className, String roomName, String building, Campus campus) {
        this.material = material;
        this.className = className;
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

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public LessonSession getLessonSession() {
        return lessonSession;
    }

    public void setLessonSession(LessonSession lessonSession) {
        this.lessonSession = lessonSession;
    }
}
