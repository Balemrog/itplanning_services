package com.timetech.itplanning_services.controller;

import com.timetech.itplanning_services.dto.FormationCreationDto;
import com.timetech.itplanning_services.dto.FormationDto;
import com.timetech.itplanning_services.model.Formation;
import com.timetech.itplanning_services.service.FormationService;
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
public class FormationController {

    private final FormationService service;

    @Autowired
    public FormationController(FormationService service){
        this.service = service;
    }

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(path = "/formations", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FormationDto> getAllFormations() {
        List<Formation> formations = service.getAllFormation();
        return formations.stream().map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/formations/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public FormationDto getFormationById(@PathVariable("id") Integer id) {
        Formation formation = service.getFormationById(id);
        return modelMapper.map(formation, FormationDto.class);
    }

    @DeleteMapping(path = "/formations/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteFormation(@PathVariable("id") Integer id) {
        if (service.getFormationById(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("The requested ID does not exist in our database.");
        }
        else {
            service.deleteFormation(id);
            return ResponseEntity.ok("resource deleted");
        }
    }

    @PostMapping(path = "/formations", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public FormationDto createFormation(@Valid @RequestBody FormationCreationDto formationCreationDto) {
        Formation formation = modelMapper.map(formationCreationDto, Formation.class);
        Formation formationCreated = service.saveFormation(formation);
        return modelMapper.map(formationCreated, FormationDto.class);
    }

    @PutMapping(path = "/formations/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public FormationDto updateFormation(@Valid @RequestBody FormationDto formationDto) {
        Formation formation = modelMapper.map(formationDto, Formation.class);
        Formation formationUpdated = service.saveFormation(formation);
        return modelMapper.map(formationUpdated, FormationDto.class);
    }

    private FormationDto convertToDto(Formation formation) {
        return modelMapper.map(formation, FormationDto.class);
    }
}
