package com.aacademy.aacademyfinalproject.converter;

import com.aacademy.aacademyfinalproject.dto.UniversityDto;
import com.aacademy.aacademyfinalproject.entity.University;
import org.springframework.stereotype.Component;

@Component
public class UniversityConverter {

    public UniversityDto toUniversityDto(University university) {
        return UniversityDto.builder()
                .id(university.getId())
                .name(university.getName())
                .build();
    }

    public University toUniversity(UniversityDto universityDto) {
        return University.builder()
                .id(universityDto.getId())
                .name(universityDto.getName())
                .build();
    }
}
