package com.aacademy.aacademyfinalproject.service.impl;

import com.aacademy.aacademyfinalproject.entity.City;
import com.aacademy.aacademyfinalproject.entity.University;
import com.aacademy.aacademyfinalproject.exception.ResourceNotFoundException;
import com.aacademy.aacademyfinalproject.repository.CityRepository;
import com.aacademy.aacademyfinalproject.service.CityService;
import com.aacademy.aacademyfinalproject.service.UniversityService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final UniversityService universityService;

    public CityServiceImpl(CityRepository cityRepository, UniversityService universityService) {
        this.cityRepository = cityRepository;
        this.universityService = universityService;
    }

    @Override
    public City save(City city) {
       Set<University> universities = new HashSet<>();
       for(University university: city.getUniversities()) {
           University foundUniversity = universityService.findById(university.getId());
           universities.add(foundUniversity);
       }

           return cityRepository.save(City.builder()
           .name(city.getName())
           .universities(universities)
           .build());

    }

    @Override
    public City findById(Long id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("City with id %d does not exists.", id)));
    }

    @Override
    public Set<City> findAll() {
        return null;
    }

    @Override
    public City update(City city, Long id) {
        City foundCity = findById(id);
        City cityToUpdate = City.builder()
                .id(foundCity.getId())
                .name(city.getName())
                .universities(city.getUniversities())
                .build();

        return cityRepository.save(cityToUpdate);
    }
}
