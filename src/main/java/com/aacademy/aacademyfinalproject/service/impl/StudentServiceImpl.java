package com.aacademy.aacademyfinalproject.service.impl;

import com.aacademy.aacademyfinalproject.entity.Student;
import com.aacademy.aacademyfinalproject.exception.DuplicateRecordException;
import com.aacademy.aacademyfinalproject.exception.ResourceNotFoundException;
import com.aacademy.aacademyfinalproject.repository.StudentRepository;
import com.aacademy.aacademyfinalproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student save(Student student) {
        try {
            return studentRepository.save(student);
        } catch (DataIntegrityViolationException exception) {
            throw new DuplicateRecordException(String.format("Student with ucn %d already exists.", student.getUcn()));
        }
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Student with id %d does not exists.", id)));
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Set<Student> findAll() {
        return new HashSet<>(studentRepository.findAll());
    }
}
