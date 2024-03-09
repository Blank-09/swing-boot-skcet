package com.priyanshu.q_01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.priyanshu.q_01.model.Purchase;
import com.priyanshu.q_01.repository.PurchaseRepo;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepo purchaseRepo;

    @Autowired
    private CustomerService customerRepo;

    public ResponseEntity<Purchase> addPurchase(int customerId, Purchase purchase) {
        purchase.setCustomer(customerRepo.getCustomer(customerId));
        return new ResponseEntity<>(purchaseRepo.save(purchase), HttpStatus.CREATED);
    }

    public List<Purchase> getPurchase() {
        return purchaseRepo.findAll();
    }

    public Purchase getPurchaseBy(int orderId) {
        return purchaseRepo.findById(orderId).orElse(null);
    }

    public List<Purchase> getPurchaseByProductName(String productName) {
        return purchaseRepo.findByProductName(productName);
    }

    public String deletePurchase(int orderId) {
        if (!purchaseRepo.existsById(orderId))
            throw new RuntimeException("Order not found");

        purchaseRepo.deleteById(orderId);
        return "Order deleted successfully";
    }

}