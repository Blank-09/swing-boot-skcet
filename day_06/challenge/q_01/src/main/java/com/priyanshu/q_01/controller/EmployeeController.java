package com.priyanshu.q_01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priyanshu.q_01.model.Employee;
import com.priyanshu.q_01.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/sortBy/{field}")
    public ResponseEntity<List<Employee>> sortBy(@PathVariable String field) {
        return employeeService.getSortedByField(field);
    }

    @GetMapping("/{offset}/{pagesize}")
    public ResponseEntity<List<Employee>> getPagination(@PathVariable int offset,
            @PathVariable int pagesize) {
        return employeeService.getPagination(offset, pagesize);
    }

    @GetMapping("/{offset}/{pagesize}/{field}")
    public ResponseEntity<List<Employee>> getSortedPagination(@PathVariable int offset,
            @PathVariable int pagesize,
            @PathVariable String field) {
        return employeeService.getSortedPagination(offset, pagesize, field);
    }

}
