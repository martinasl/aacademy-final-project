package com.aacademy.aacademyfinalproject.service.serviceImpl.func;

import com.aacademy.aacademyfinalproject.entity.Student;
import com.aacademy.aacademyfinalproject.repository.StudentRepository;
import com.aacademy.aacademyfinalproject.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class StudentServiceFuncTest {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;


}
