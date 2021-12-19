package com.aacademy.aacademyfinalproject.repository;

import com.aacademy.aacademyfinalproject.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends JpaRepository<University, Long> {
}
