package com.timetech.itplanning_services.controller;

import com.timetech.itplanning_services.dto.LoginDto;
import com.timetech.itplanning_services.dto.UserDto;
import com.timetech.itplanning_services.model.User;
import com.timetech.itplanning_services.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class LoginController {

    private final UserService service;

    @Autowired
    public LoginController(UserService service){
        this.service = service;
    }

    @PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> createTeacher(@Valid @RequestBody LoginDto loginDto) {
        Optional<User> userOptional = service.validLoginAndPassword(loginDto.getUsername(), loginDto.getPassword());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return ResponseEntity.status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(new UserDto(user.getId(), user.getLogin(), user.getRole()));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
