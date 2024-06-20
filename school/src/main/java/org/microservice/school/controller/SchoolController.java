package org.microservice.school.controller;

import lombok.RequiredArgsConstructor;
import org.microservice.school.entity.School;
import org.microservice.school.service.SchoolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/school")
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolService schoolService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(schoolService.findAll());
    }

    @GetMapping("/{schoolID}")
    public ResponseEntity<?> getSchoolWithStudent(@PathVariable Integer schoolID) {
        return ResponseEntity.ok(schoolService.findSchoolWithStudent(schoolID));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody School school) {
        return ResponseEntity.ok(schoolService.save(school));
    }
}
