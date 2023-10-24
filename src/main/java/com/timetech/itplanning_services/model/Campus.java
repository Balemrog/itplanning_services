package com.timetech.itplanning_services.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "campus")
public class Campus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Public.class)
    private int id;

    @NotNull
    @JsonView(Views.Public.class)
    private String location;

    @ManyToMany
    @JoinTable(name="campus_formation",
            joinColumns=@JoinColumn(name="campus_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="formation_id", referencedColumnName="id")
    )
    @JsonView(Views.Internal.class)
    private List<Formation> formations;
    
    @OneToMany(mappedBy = "campus")
    @JsonView(Views.Internal.class)
    private List<Room> rooms;

    public Campus() {
    }

    public Campus(String location) {
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

    @Override
    public String toString() {
        return "Campus{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", formations=" + formations +
                ", rooms=" + rooms +
                '}';
    }
}
