package com.aacademy.aacademyfinalproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class StudentDto {
    private Long id;

    private String name;

    private String ucn;
}
