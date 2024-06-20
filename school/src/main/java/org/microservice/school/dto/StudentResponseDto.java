package org.microservice.school.dto;

import lombok.Builder;

@Builder
public record StudentResponseDto(
        Integer id,
        String firstname,
        String lastname,
        String email
) {
}
