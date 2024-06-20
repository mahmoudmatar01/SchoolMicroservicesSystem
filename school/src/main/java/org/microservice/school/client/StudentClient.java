package org.microservice.school.client;

import org.microservice.school.dto.StudentResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
@FeignClient(name="StudentClient",url = "${application.config.student-url}")
public interface StudentClient {

    @GetMapping("/school/{schoolId}")
    List<StudentResponseDto>findAllStudentBySchoolId(@PathVariable("schoolId") Integer schoolId);
}
