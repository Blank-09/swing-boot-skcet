package com.priyanshu.q_03.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.priyanshu.q_03.model.Product;
import com.priyanshu.q_03.repository.ProductRepo;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public ResponseEntity<Product> addProduct(Product product) {
        return new ResponseEntity<>(productRepo.save(product), HttpStatus.CREATED);
    }

    public ResponseEntity<List<Product>> getPagination(int offset, int pagesize) {
        Pageable pg = PageRequest.of(offset, pagesize);
        return ResponseEntity.ok(productRepo.findAll(pg).getContent());
    }

    public ResponseEntity<List<Product>> getSortedPagination(int offset, int pagesize, String field) {
        Sort sort = Sort.by(field);
        Pageable pg = PageRequest.of(offset, pagesize, sort);
        return ResponseEntity.ok(productRepo.findAll(pg).getContent());
    }

    public ResponseEntity<Product> getProductById(int productId) {
        Optional<Product> product = productRepo.findById(productId);

        if (product.isPresent()) {
            return ResponseEntity.ok(product.get());
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
