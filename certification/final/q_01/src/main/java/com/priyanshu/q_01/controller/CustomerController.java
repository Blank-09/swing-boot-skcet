package com.priyanshu.q_01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priyanshu.q_01.model.Customer;
import com.priyanshu.q_01.service.CustomerService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @GetMapping("/{customerId}")
    public Customer getMethodName(@PathVariable int customerId) {
        return customerService.getCustomer(customerId);
    }

    @GetMapping("/findByFirstname/{firstName}")
    public List<Customer> getCustomerByFirstName(@PathVariable String firstName) {
        return customerService.getCustomerByFirstName(firstName);
    }

    @GetMapping("/startswith/{firstName}")
    public List<Customer> getCustomerStartsWith(@PathVariable String firstName) {
        return customerService.getCustomerStartsWith(firstName);
    }

    @GetMapping("/{pageNo}/{pageSize}")
    public List<Customer> getCustomerByPage(@PathVariable int pageNo, @PathVariable int pageSize) {
        return customerService.getCustomerByPage(pageNo, pageSize);
    }

}