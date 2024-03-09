package com.priyanshu.q_01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.priyanshu.q_01.model.Customer;
import com.priyanshu.q_01.repository.CustomerRepo;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public ResponseEntity<Customer> addCustomer(Customer customer) {
        return new ResponseEntity<>(customerRepo.save(customer), HttpStatus.CREATED);
    }

    public Customer getCustomer(int customerId) {
        return customerRepo.findById(customerId).orElse(null);
    }

    public List<Customer> getCustomerByFirstName(String firstName) {
        return customerRepo.findByFirstName(firstName);
    }

    public List<Customer> getCustomerStartsWith(String firstName) {
        return customerRepo.findByFirstNameStartsWith(firstName);
    }

    public List<Customer> getCustomerByPage(int pageNo, int pageSize) {
        return customerRepo.findAll(PageRequest.of(pageNo, pageSize)).getContent();
    }

}