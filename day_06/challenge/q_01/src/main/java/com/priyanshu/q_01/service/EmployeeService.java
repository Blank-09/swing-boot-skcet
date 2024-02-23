package com.priyanshu.q_01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.priyanshu.q_01.model.Employee;
import com.priyanshu.q_01.repository.EmployeeRepo;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public ResponseEntity<Employee> addEmployee(Employee employee) {
        return new ResponseEntity<>(employeeRepo.save(employee), HttpStatus.CREATED);
    }

    public ResponseEntity<List<Employee>> getSortedByField(String field) {
        Sort sort = Sort.by(field);
        return new ResponseEntity<>(employeeRepo.findAll(sort), HttpStatus.OK);
    }

    public ResponseEntity<List<Employee>> getPagination(int offset, int pagesize) {
        Pageable pg = PageRequest.of(offset, pagesize);
        return ResponseEntity.ok(employeeRepo.findAll(pg).getContent());
    }

    public ResponseEntity<List<Employee>> getSortedPagination(int offset, int pagesize, String field) {
        Sort sort = Sort.by(field);
        Pageable pg = PageRequest.of(offset, pagesize, sort);
        return ResponseEntity.ok(employeeRepo.findAll(pg).getContent());
    }
}
