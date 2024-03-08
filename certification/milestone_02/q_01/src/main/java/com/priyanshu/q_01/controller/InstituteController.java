package com.priyanshu.q_01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priyanshu.q_01.model.Course;
import com.priyanshu.q_01.model.Institute;
import com.priyanshu.q_01.service.InstituteService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/institute")
public class InstituteController {

    @Autowired
    private InstituteService instituteService;

    @PostMapping
    public ResponseEntity<Institute> addInstitute(@RequestBody Institute institute) {
        return instituteService.add(institute);
    }

    @PostMapping("/{instituteId}/course")
    public ResponseEntity<Course> addCourse(@PathVariable int instituteId, @RequestBody Course course) {
        return instituteService.addCourseInInstitute(instituteId, course);
    }

    @GetMapping
    public List<Institute> getAllInstitutes() {
        return instituteService.getAllInstitutes();
    }

    @PutMapping("/{instituteId}")
    public ResponseEntity<Institute> updateInstitute(@PathVariable int instituteId, @RequestBody Institute institute) {
        return instituteService.updateInstitute(instituteId, institute);
    }

}
