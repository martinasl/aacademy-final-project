package com.aacademy.aacademyfinalproject.controller;

import com.aacademy.aacademyfinalproject.converter.StudentConverter;
import com.aacademy.aacademyfinalproject.dto.StudentDto;
import com.aacademy.aacademyfinalproject.entity.Student;
import com.aacademy.aacademyfinalproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

    private final StudentService studentService;
    private final StudentConverter studentConverter;

    @Autowired
    public StudentController(StudentService studentService, StudentConverter studentConverter) {
        this.studentService = studentService;
        this.studentConverter = studentConverter;
    }

    @PostMapping
    public ResponseEntity<StudentDto> save(@RequestBody @Valid StudentDto studentDto) {
        Student student = studentConverter.toStudent(studentDto);
        Student savedStudent = studentService.save(student);
        return ResponseEntity.ok(studentConverter.toStudentDto(savedStudent));
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<StudentDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(studentConverter.toStudentDto((studentService.findById(id))));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        studentService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Set<StudentDto>> findAll() {
        return ResponseEntity.ok(studentService.findAll()
                .stream()
                .map(studentConverter::toStudentDto)
                .collect(Collectors.toSet()));
    }
}
