package com.timetech.itplanning_services.controller;

import com.timetech.itplanning_services.dto.CampusCreationDto;
import com.timetech.itplanning_services.dto.CampusDto;
import com.timetech.itplanning_services.model.Campus;
import com.timetech.itplanning_services.service.CampusService;
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
public class CampusController {

    private final CampusService service;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public CampusController(CampusService service) {
        this.service = service;
    }

    @GetMapping(path = "/campuses", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CampusDto> getAllCampus() {
        List<Campus> campuses = service.getAllCampus();
        return campuses.stream().map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/campuses/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CampusDto getCampusById(@PathVariable("id") Integer id) {
        Campus campus = service.getCampusById(id);
        return modelMapper.map(campus, CampusDto.class);
    }

    @DeleteMapping(path = "/campuses/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteCampus(@PathVariable("id") Integer id) {
        if (service.getCampusById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("The requested ID does not exist in our database.");
        }
        else {
            service.deleteCampus(id);
            return ResponseEntity.ok("resource deleted");
        }
    }

    @PostMapping(path = "/campuses", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public CampusDto createCampus(@Valid @RequestBody CampusCreationDto campusCreationDto) {
        Campus campus = modelMapper.map(campusCreationDto, Campus.class);
        Campus campusCreated = service.saveCampus(campus);
        return modelMapper.map(campusCreated, CampusDto.class);
    }

    @PutMapping(path = "/campuses/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public CampusDto updateCampus(@Valid @RequestBody CampusDto campusDto) {
        Campus campus = modelMapper.map(campusDto, Campus.class);
        Campus campusUpdated = service.saveCampus(campus);
        return modelMapper.map(campusUpdated, CampusDto.class);
    }

    private CampusDto convertToDto(Campus campus) {
        return modelMapper.map(campus, CampusDto.class);
    }
}
