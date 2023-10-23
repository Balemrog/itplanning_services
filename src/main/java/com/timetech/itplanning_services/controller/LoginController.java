package com.timetech.itplanning_services.controller;

import com.timetech.itplanning_services.dto.LoginDto;
import com.timetech.itplanning_services.dto.UserDto;
import com.timetech.itplanning_services.model.User;
import com.timetech.itplanning_services.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    private final UserService service;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public LoginController(UserService service){
        this.service = service;
    }

    @PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createTeacher(@RequestBody LoginDto loginDto) {
        User user = service.getUserByLogin(loginDto.getUsername());
        boolean isCorrectPassword = passwordEncoder.matches(loginDto.getPassword(), user.getPassword());
        if (isCorrectPassword) {
            UserDto userDto = new UserDto(user.getId(), user.getLogin(), user.getRole());
            return ResponseEntity.status(HttpStatus.OK)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(userDto);
        }
        else {
            String error = "error: mauvais mdp";
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(error);
        }
    }
}
