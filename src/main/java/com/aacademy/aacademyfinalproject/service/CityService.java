package com.aacademy.aacademyfinalproject.service;

import com.aacademy.aacademyfinalproject.entity.City;

import java.util.Set;

public interface CityService {
    City save(City city);

    City findById(Long id);

    Set<City> findAll();

    City update (City city, Long id);

}
