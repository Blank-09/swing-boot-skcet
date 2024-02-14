package com.priyanshu.q_03.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priyanshu.q_03.model.Student;

@RestController
public class StudentController {

    @GetMapping("/student")
    public List<Student> getMethodString() {
        List<Student> list = new ArrayList<>();
        list.add(new Student("John", "Welcome, John!"));
        list.add(new Student("John", "Welcome, John!"));
        return list;
    }
}