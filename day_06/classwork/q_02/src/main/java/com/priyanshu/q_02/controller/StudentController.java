package com.priyanshu.q_02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priyanshu.q_02.model.Student;
import com.priyanshu.q_02.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> addStudentEntity(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents(@RequestParam int pageNo, @RequestParam int pageSize) {
        return studentService.getAllStudents(pageNo - 1, pageSize);
    }

    @GetMapping("/sort")
    public List<Student> getSortedStudents(@RequestParam int pageNo, @RequestParam int pageSize,
            @RequestParam String sortBy) {
        return studentService.getSortedStudents(pageNo - 1, pageSize, sortBy);
    }

}