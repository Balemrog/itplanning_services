package com.timetech.itplanning_services.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "campus")
public class Campus {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    @Size(max=100)
    private String location;

    @ManyToMany
    @JoinTable(name="campus_formation",
            joinColumns=@JoinColumn(name="campus_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="formation_id", referencedColumnName="id")
    )
    private List<Formation> formations;
    
    @OneToMany(mappedBy = "campus")
    private List<Room> rooms;

    public Campus() {
    }

    public Campus(int id, String location) {
        this.id = id;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Formation> getFormations() {
        return formations;
    }

    public void setFormations(List<Formation> formations) {
        this.formations = formations;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
