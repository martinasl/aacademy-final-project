package com.aacademy.aacademyfinalproject.controller;


import com.aacademy.aacademyfinalproject.converter.CityConverter;
import com.aacademy.aacademyfinalproject.dto.CityDto;
import com.aacademy.aacademyfinalproject.entity.City;
import com.aacademy.aacademyfinalproject.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/cities2")
public class CityController {

    private final CityService cityService;
    private final CityConverter cityConverter;

    public CityController(CityService cityService, CityConverter cityConverter) {
        this.cityService = cityService;
        this.cityConverter = cityConverter;
    }

    @PostMapping
    public ResponseEntity<CityDto> save(@RequestBody CityDto cityDto) {
        City city = cityConverter.toCity(cityDto);
        City savedCity = cityService.save(city);
        CityDto cityDtoResponse = cityConverter.toCityDto(savedCity);
        return ResponseEntity.ok(cityDtoResponse);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CityDto> findById(@PathVariable Long id) {
        City foundCity = cityService.findById(id);
        CityDto cityDto = cityConverter.toCityDto(foundCity);

        return ResponseEntity.ok(cityDto);
    }

    @GetMapping
    public ResponseEntity<Set<CityDto>> findAll() {
        return ResponseEntity.ok(cityService.findAll()
                .stream()
                .map(cityConverter::toCityDto)
                .collect(Collectors.toSet()));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CityDto> update(@RequestBody CityDto cityDto, @PathVariable Long id) {
        City city = cityConverter.toCity(cityDto);
        City savedCity = cityService.update(city, id);
        CityDto cityDtoResponse = cityConverter.toCityDto(savedCity);
        return ResponseEntity.ok(cityDtoResponse);
    }
}
