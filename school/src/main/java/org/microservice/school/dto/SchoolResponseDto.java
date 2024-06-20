package org.microservice.school.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record SchoolResponseDto (
        Integer schoolId,
        String schoolName,
        String schoolAddress,
        List<StudentResponseDto> students
){
}
