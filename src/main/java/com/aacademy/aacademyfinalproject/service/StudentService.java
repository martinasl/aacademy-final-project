package com.aacademy.aacademyfinalproject.service;

import com.aacademy.aacademyfinalproject.entity.Student;

import java.util.Set;

public interface StudentService {
    Student save(Student student);

    Student findById(Long id);

    void delete(Long id);

    Set<Student> findAll();
}
