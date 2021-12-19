package com.aacademy.aacademyfinalproject.repository;

import com.aacademy.aacademyfinalproject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
