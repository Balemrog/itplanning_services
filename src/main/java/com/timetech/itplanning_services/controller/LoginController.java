package com.timetech.itplanning_services.controller;

import com.timetech.itplanning_services.dto.LoginDto;
import com.timetech.itplanning_services.dto.UserDto;
import com.timetech.itplanning_services.model.User;
import com.timetech.itplanning_services.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    private UserService service;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public LoginController(UserService service){
        this.service = service;
    }

    @PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createTeacher(@RequestBody LoginDto loginDto) {
        System.out.println("jsuis rentrer ici" + loginDto);
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

//    @GetMapping(path = "/teachers", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Map<String, List<Teacher>>> getAllTeachers() {
//        List<Teacher> teachers = service.getAllTeacher();
//        Map<String, List<Teacher>> test = Collections.singletonMap("data",teachers);
//        return ResponseEntity.status(HttpStatus.OK)
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(Collections.singletonMap("data", teachers));
//    }

//    @GetMapping(path = "/teacher/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Teacher> getTeacherById(@PathVariable("id") Integer id) {
//        return ResponseEntity.status(HttpStatus.OK)
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(service.getTeacherById(id));
//    }

//    @DeleteMapping(path = "/teacher/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> deleteTeacher(@PathVariable("id") Integer id) {
//        service.deleteTeacher(id);
//        return ResponseEntity.ok("resource deleted");
//    }

//    @PutMapping(path = "/teacher/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> saveResource(
//            @RequestBody Teacher teacher,
//            @PathVariable("id") Integer id) {
////        service.updateTeacher(teacher, id);
//        return ResponseEntity.ok("resource saved");
//    }

//    @PatchMapping(path = "/teacher/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> partialUpdateGeneric(
//            @RequestBody Map<String, Object> updates,
//            @PathVariable("id") String id) {
////        updates.put("address", "5th avenue");
////        service.partialUpdateTeacher(updates, id);
//        return ResponseEntity.ok("resource updated");
//    }
}
