package com.aacademy.aacademyfinalproject.controller;

import com.aacademy.aacademyfinalproject.converter.UniversityConverter;
import com.aacademy.aacademyfinalproject.dto.UniversityDto;
import com.aacademy.aacademyfinalproject.entity.University;
import com.aacademy.aacademyfinalproject.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/universities")
public class UniversityController {

    private final UniversityService universityService;
    private final UniversityConverter universityConverter;

@Autowired
    public UniversityController(UniversityService universityService, UniversityConverter universityConverter) {
        this.universityService = universityService;
        this.universityConverter = universityConverter;
    }

    @PostMapping
    public ResponseEntity<UniversityDto> save(@RequestBody UniversityDto universityDto){
        return ResponseEntity.ok(universityConverter.toUniversityDto(
                universityService.save(universityConverter.toUniversity(universityDto))));
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<UniversityDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(universityConverter.toUniversityDto((universityService.findById(id))));
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<UniversityDto> findByName(@PathVariable String name) {
        return ResponseEntity.ok(universityConverter.toUniversityDto((universityService.findByName(name))));
    }

    @GetMapping
    public ResponseEntity<Set<UniversityDto>> findAll() {
        return ResponseEntity.ok(universityService.findAll()
                .stream()
                .map(universityConverter::toUniversityDto)
                .collect(Collectors.toSet()));
    }
}
