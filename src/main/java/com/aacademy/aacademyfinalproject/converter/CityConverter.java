package com.aacademy.aacademyfinalproject.converter;

import com.aacademy.aacademyfinalproject.dto.CityDto;
import com.aacademy.aacademyfinalproject.entity.City;
import com.aacademy.aacademyfinalproject.entity.University;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CityConverter {

    public CityDto toCityDto(City city) {
        return CityDto.builder()
                .id(city.getId())
                .name(city.getName())
                .universityIds(city.getUniversities()
                        .stream()
                        .map(University::getId)
                        .collect(Collectors.toSet()))
                .build();
    }

    public City toCity(CityDto cityDto) {
        return City.builder()
                .id(cityDto.getId())
                .name(cityDto.getName())
                .universities(cityDto.getUniversityIds()
                        .stream()
                        .map((universityId) ->
                                University.builder().id(universityId).build())
                        .collect(Collectors.toSet()))
                .build();
    }
}
