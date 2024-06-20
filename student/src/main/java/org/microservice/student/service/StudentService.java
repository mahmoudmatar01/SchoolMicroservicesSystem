package org.microservice.student.service;

import lombok.RequiredArgsConstructor;
import org.microservice.student.entity.Student;
import org.microservice.student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public void save(Student student) {
        studentRepository.save(student);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public List<Student> findStudentBySchoolId(Integer schoolId) {
        return studentRepository.findBySchoolId(schoolId);
    }
}
