package org.microservice.school.service;

import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.microservice.school.client.StudentClient;
import org.microservice.school.dto.SchoolResponseDto;
import org.microservice.school.dto.StudentResponseDto;
import org.microservice.school.entity.School;
import org.microservice.school.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository schoolRepository;
    private final StudentClient studentClient;

    public School save(School school) {
        return schoolRepository.save(school);
    }

    public List<School> findAll() {
        return schoolRepository.findAll();
    }

    public SchoolResponseDto findSchoolWithStudent(Integer schoolID) {
        School school=schoolRepository.findById(schoolID).orElseThrow(
                ()->new NotFoundException("School not found!")
        );
        // find all the student from the student micro-service
        List<StudentResponseDto> students=studentClient.findAllStudentBySchoolId(schoolID);
        return SchoolResponseDto.builder()
                .schoolId(school.getSchoolId())
                .schoolAddress(school.getSchoolAddress())
                .schoolName(school.getSchoolName())
                .students(students)
                .build();
    }
}
