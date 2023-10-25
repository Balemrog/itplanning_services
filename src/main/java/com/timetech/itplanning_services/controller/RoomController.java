package com.timetech.itplanning_services.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.timetech.itplanning_services.model.Room;
import com.timetech.itplanning_services.model.Views;
import com.timetech.itplanning_services.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
public class RoomController {

    private final RoomService service;

    @Autowired
    public RoomController(RoomService service){
        this.service = service;
    }

    @GetMapping(path = "/rooms", produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(Views.Public.class)
    public ResponseEntity<Map<String, List<Room>>> getAllRoom() {
        List<Room> rooms = service.getAllRoom();
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Collections.singletonMap("data", rooms));
    }

    @GetMapping(path = "/rooms/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(Views.Public.class)
    public ResponseEntity<Room> getRoomById(@PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.getRoomById(id));
    }

    @DeleteMapping(path = "/rooms/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteRoom(@PathVariable("id") Integer id) {
        if (service.getRoomById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("The requested ID does not exist in our database.");
        }
        else {
            service.deleteRoom(id);
            return ResponseEntity.ok("resource deleted");
        }
    }

    @PostMapping(path = "/rooms", consumes = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(Views.Public.class)
    public ResponseEntity<Room> createRoom(@RequestBody Room room) {
        System.out.println("DSFSDFSDFDSDSFSDSDF");
        System.out.println(room);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.saveRoom(room));
    }

    @PutMapping(path = "/rooms/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(Views.Public.class)
    public ResponseEntity<Room> updateRoom(@Valid @RequestBody Room room) {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.saveRoom(room));
    }
}
