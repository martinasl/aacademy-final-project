package com.aacademy.aacademyfinalproject.service.impl;

import com.aacademy.aacademyfinalproject.entity.University;
import com.aacademy.aacademyfinalproject.exception.ResourceNotFoundException;
import com.aacademy.aacademyfinalproject.repository.UniversityRepository;
import com.aacademy.aacademyfinalproject.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class UniversityServiceImpl implements UniversityService {

    private final UniversityRepository universityRepository;

    @Autowired
    public UniversityServiceImpl(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    @Override
    public University save(University university) {
        return universityRepository.save(university);
    }

    @Override
    public University findById(Long id) {
        return universityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("University with id: %d does not exists.", id)));

    }

    @Override
    public University findByName(String name) {
        return universityRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("University with name: %d does not exists.", name)));

    }

    @Override
    public Set<University> findAll() {
        return new HashSet<>(universityRepository.findAll());
    }
}
