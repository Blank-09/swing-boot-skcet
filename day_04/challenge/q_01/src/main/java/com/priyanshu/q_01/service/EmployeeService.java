package com.priyanshu.q_01.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priyanshu.q_01.model.Employee;
import com.priyanshu.q_01.repository.EmployeeRepo;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepo.findById(id);
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }
}
