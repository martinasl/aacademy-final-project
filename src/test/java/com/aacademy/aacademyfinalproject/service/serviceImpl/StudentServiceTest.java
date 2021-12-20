package com.aacademy.aacademyfinalproject.service.serviceImpl;

import com.aacademy.aacademyfinalproject.entity.Student;
import com.aacademy.aacademyfinalproject.exception.DuplicateRecordException;
import com.aacademy.aacademyfinalproject.exception.ResourceNotFoundException;
import com.aacademy.aacademyfinalproject.repository.StudentRepository;
import com.aacademy.aacademyfinalproject.service.impl.StudentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.Mockito.*;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentServiceImpl;

    private Student student;

    @Test
    public void verifySave(){
        Student studentSave = Student.builder().build();
        when(studentRepository.save(any(Student.class))).thenReturn(studentSave);
        studentServiceImpl.save(studentSave);
        verify(studentRepository, times(1)).save(studentSave);
    }

    @Test
    public void verifyFindById() {
        when(studentRepository.findById(any(Long.class)))
                .thenReturn(Optional.of(Student.builder().build()));

        studentServiceImpl.findById(1L);
        verify(studentRepository, times(1)).findById(1L);
    }

    @Test
    public void verifyDelete() {
        doNothing().when(studentRepository).deleteById(any(Long.class));

        studentServiceImpl.delete(1L);

        verify(studentRepository, times(1)).deleteById(1L);
    }

    @Test
    public void verifyFindAll(){
        when(studentRepository.findAll()).thenReturn(Collections.emptyList());
        studentServiceImpl.findAll();
        verify(studentRepository, times(1)).findAll();
    }

    @Test(expected = ResourceNotFoundException.class)
    public void verifyByIdException() {
        when(studentRepository.findById(any(Long.class)))
                .thenReturn(Optional.empty());

       studentServiceImpl.findById(1L);
    }

    @Test(expected = DuplicateRecordException.class)
    public void verifySaveDuplicateException() {
        when(studentRepository.save(any(Student.class)))
                .thenThrow(DataIntegrityViolationException.class);

        studentServiceImpl.save(Student.builder().build());
    }
}
