package com.priyanshu.q_01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priyanshu.q_01.model.Purchase;
import com.priyanshu.q_01.service.PurchaseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/customer")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("/{customerId}/purchase")
    public ResponseEntity<Purchase> addPurchase(@PathVariable int customerId, @RequestBody Purchase purchase) {
        return purchaseService.addPurchase(customerId, purchase);
    }

    @GetMapping("purchase")
    public List<Purchase> getPurchase() {
        return purchaseService.getPurchase();
    }

    @GetMapping("purchase/{orderId}")
    public Purchase getPurchase(@PathVariable int orderId) {
        return purchaseService.getPurchaseBy(orderId);
    }

    @GetMapping("purchase/findbyproductname/{productName}")
    public List<Purchase> getPurchaseByProductName(@PathVariable String productName) {
        return purchaseService.getPurchaseByProductName(productName);
    }

    @DeleteMapping("purchase/{orderId}")
    public String deletePurchase(@PathVariable int orderId) {
        return purchaseService.deletePurchase(orderId);
    }

}