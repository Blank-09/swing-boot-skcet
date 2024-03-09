package com.priyanshu.q_01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.priyanshu.q_01.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    List<Customer> findByFirstName(String firstName);

    List<Customer> findByFirstNameStartsWith(String firstName);

}