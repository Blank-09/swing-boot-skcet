package com.priyanshu.q_02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.priyanshu.q_02.model.Student;
import com.priyanshu.q_02.repository.StudentRepo;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public ResponseEntity<Student> addStudent(Student student) {
        return new ResponseEntity<>(studentRepo.save(student), HttpStatus.CREATED);
    }

    public List<Student> getAllStudents(int pageNo, int pageSize) {
        return studentRepo.findAll(PageRequest.of(pageNo, pageSize)).getContent();
    }

    public List<Student> getSortedStudents(int pageNo, int pageSize, String sortBy) {
        Sort sort = Sort.by(sortBy);
        return studentRepo.findAll(PageRequest.of(pageNo, pageSize, sort)).getContent();
    }

}