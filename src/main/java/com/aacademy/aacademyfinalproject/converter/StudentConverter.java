package com.aacademy.aacademyfinalproject.converter;

import com.aacademy.aacademyfinalproject.dto.StudentDto;
import com.aacademy.aacademyfinalproject.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentConverter {

    public StudentDto toStudentDto(Student student) {
        return StudentDto.builder()
                .id(student.getId())
                .name(student.getName())
                .ucn(student.getUcn())
                .build();
    }

    public Student toStudent(StudentDto studentDto) {
        return Student.builder()
                .id(studentDto.getId())
                .name(studentDto.getName())
                .ucn(studentDto.getUcn())
                .build();
    }
}
