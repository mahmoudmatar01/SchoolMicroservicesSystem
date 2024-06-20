package org.microservice.student.controller;

import lombok.RequiredArgsConstructor;
import org.microservice.student.entity.Student;
import org.microservice.student.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<?> getAllStudents() {
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/school/{schoolId}")
    public ResponseEntity<?> getStudentsBySchoolId(@PathVariable Integer schoolId) {
        return ResponseEntity.ok(studentService.findStudentBySchoolId(schoolId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody Student student) {
        studentService.save(student);
    }
}
