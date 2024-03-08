package com.priyanshu.q_01.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.priyanshu.q_01.model.Course;
import com.priyanshu.q_01.repository.CourseRepo;

@Service
public class CourseService {

    @Autowired
    private CourseRepo courseRepo;

    public List<Course> getCourseByInstituteId(int instituteId) {
        return courseRepo.findByInstituteId(instituteId);
    }

    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    public ResponseEntity<Course> getCourseById(int courseId) {
        Optional<Course> course = courseRepo.findById(courseId);

        if (course.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(course.get());
    }

    public ResponseEntity<Course> updateCourse(int courseId, Course course) {
        Optional<Course> existing = courseRepo.findById(courseId);

        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Course updatedCourse = existing.get();
        updatedCourse.setCourseName(course.getCourseName());
        updatedCourse.setCourseDescription(course.getCourseDescription());
        updatedCourse.setCourseDuration(course.getCourseDuration());
        updatedCourse.setCourseFees(course.getCourseFees());
        updatedCourse.setNoOfSeats(course.getNoOfSeats());
        courseRepo.save(updatedCourse);

        return ResponseEntity.ok(updatedCourse);
    }

    public void deleteById(int courseId) {
        courseRepo.deleteById(courseId);
    }

}
