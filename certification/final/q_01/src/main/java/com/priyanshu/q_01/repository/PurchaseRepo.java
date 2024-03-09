package com.priyanshu.q_01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.priyanshu.q_01.model.Purchase;

public interface PurchaseRepo extends JpaRepository<Purchase, Integer> {

    List<Purchase> findByProductName(String productName);
}