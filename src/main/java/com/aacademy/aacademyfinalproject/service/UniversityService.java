package com.aacademy.aacademyfinalproject.service;

import com.aacademy.aacademyfinalproject.entity.University;

import java.util.Set;

public interface UniversityService {
    University save(University university);

    University findById(Long id);

    University findByName(String name);

    Set<University> findAll();

}
