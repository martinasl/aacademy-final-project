package com.aacademy.aacademyfinalproject.repository;

import com.aacademy.aacademyfinalproject.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
