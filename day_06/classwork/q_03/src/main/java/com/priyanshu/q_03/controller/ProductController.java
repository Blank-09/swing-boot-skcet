package com.priyanshu.q_03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priyanshu.q_03.model.Product;
import com.priyanshu.q_03.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @GetMapping("/{offset}/{pagesize}")
    public ResponseEntity<List<Product>> getPagination(@PathVariable int offset,
            @PathVariable int pagesize) {
        return productService.getPagination(offset, pagesize);
    }

    @GetMapping("/{offset}/{pagesize}/{field}")
    public ResponseEntity<List<Product>> getSortedPagination(@PathVariable int offset,
            @PathVariable int pagesize,
            @PathVariable String field) {
        return productService.getSortedPagination(offset, pagesize, field);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable int productId) {
        return productService.getProductById(productId);
    }

}