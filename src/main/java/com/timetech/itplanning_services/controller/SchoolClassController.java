package com.timetech.itplanning_services.controller;

import com.timetech.itplanning_services.dto.*;
import com.timetech.itplanning_services.model.SchoolClass;
import com.timetech.itplanning_services.service.SchoolClassService;
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
public class SchoolClassController {

    private final SchoolClassService service;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public SchoolClassController(SchoolClassService service){
        this.service = service;
    }

    @GetMapping(path = "/school-classes", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SchoolClassDto> getAllSchoolClass() {
        List<SchoolClass> schoolClasses = service.getAllSchoolClass();
        return schoolClasses.stream().map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/school-classes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SchoolClassDto getSchoolClassById(@PathVariable("id") Integer id) {
        SchoolClass schoolClass = service.getSchoolClassById(id);
        return modelMapper.map(schoolClass, SchoolClassDto.class);
    }

    @DeleteMapping(path = "/school-classes/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteSchoolClass(@PathVariable("id") Integer id) {
        if (service.getSchoolClassById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("The requested ID does not exist in our database.");
        }
        else {
            service.deleteSchoolClass(id);
            return ResponseEntity.ok("resource deleted");
        }
    }

    @PostMapping(path = "/school-classes", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public SchoolClassDto createSchoolClass(@Valid @RequestBody SchoolClassCreationDto schoolClassCreationDto) {
        SchoolClass schoolClass = modelMapper.map(schoolClassCreationDto, SchoolClass.class);
        SchoolClass schoolClassCreated = service.saveSchoolClass(schoolClass);
        return modelMapper.map(schoolClassCreated, SchoolClassDto.class);
    }

    @PutMapping(path = "/school-classes/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public SchoolClassDto updateSchoolClass(@Valid @RequestBody SchoolClassUpdateDto schoolClassUpdateDto) {
        SchoolClass schoolClass = modelMapper.map(schoolClassUpdateDto, SchoolClass.class);
        SchoolClass schoolClassUpdated = service.saveSchoolClass(schoolClass);
        return modelMapper.map(schoolClassUpdated, SchoolClassDto.class);
    }

    private SchoolClassDto convertToDto(SchoolClass schoolClass) {
        return modelMapper.map(schoolClass, SchoolClassDto.class);
    }
}
