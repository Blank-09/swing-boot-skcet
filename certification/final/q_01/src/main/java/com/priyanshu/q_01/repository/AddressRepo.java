package com.priyanshu.q_01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.priyanshu.q_01.model.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

    List<Address> findByCityEndsWith(String city);

}