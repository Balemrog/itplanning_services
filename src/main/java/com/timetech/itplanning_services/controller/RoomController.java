package com.timetech.itplanning_services.controller;

import com.timetech.itplanning_services.dto.*;
import com.timetech.itplanning_services.model.Room;
import com.timetech.itplanning_services.service.CampusService;
import com.timetech.itplanning_services.service.RoomService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/admin")
public class RoomController {

    private final RoomService service;

    @Autowired
    private CampusService campusService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public RoomController(RoomService service){
        this.service = service;
    }

    @GetMapping(path = "/rooms", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RoomDto> getAllRoom() {
        List<Room> rooms = service.getAllRoom();
        return rooms.stream().map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/rooms/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RoomDto getRoomById(@PathVariable("id") Integer id) {
        Room room = service.getRoomById(id);
        return modelMapper.map(room, RoomDto.class);
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
    @ResponseStatus(HttpStatus.CREATED)
    public RoomDto createRoom(@RequestBody RoomCreationDto roomCreationDto) {
        Room room = modelMapper.map(roomCreationDto, Room.class);
        Room roomCreated = service.saveRoom(room);
        return modelMapper.map(roomCreated, RoomDto.class);
    }

    @PutMapping(path = "/rooms/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public RoomDto updateRoom(@Valid @RequestBody RoomUpdateDto roomUpdateDto) {
        Room room = modelMapper.map(roomUpdateDto, Room.class);
        Room roomUpdated = service.saveRoom(room);
        return modelMapper.map(roomUpdated, RoomDto.class);
    }

    private RoomDto convertToDto(Room room) {
        return modelMapper.map(room, RoomDto.class);
    }
}
