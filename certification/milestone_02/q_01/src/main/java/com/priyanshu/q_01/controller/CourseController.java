package com.priyanshu.q_01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priyanshu.q_01.model.Course;
import com.priyanshu.q_01.service.CourseService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/institute")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/{instituteId}/course")
    public List<Course> getCourseByInstituteId(@PathVariable int instituteId) {
        return courseService.getCourseByInstituteId(instituteId);
    }

    @GetMapping("/course")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<Course> getCourseById(@PathVariable int courseId) {
        return courseService.getCourseById(courseId);
    }

    @PutMapping("/course/{courseId}")
    public ResponseEntity<Course> updateCourse(@PathVariable int courseId, @RequestBody Course course) {
        return courseService.updateCourse(courseId, course);
    }

    @DeleteMapping("/course/{courseId}")
    public void deleteCourse(@PathVariable int courseId) {
        courseService.deleteById(courseId);
    }

}