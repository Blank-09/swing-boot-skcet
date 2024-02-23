package com.priyanshu.q_01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.priyanshu.q_01.model.Children;
import com.priyanshu.q_01.repository.ChildrenRepo;

@Service
public class ChildrenService {

    @Autowired
    private ChildrenRepo childrenRepo;

    public ResponseEntity<Children> addChild(Children child) {
        return new ResponseEntity<>(childrenRepo.save(child), HttpStatus.CREATED);
    }

    public ResponseEntity<List<Children>> getSortedChildrenByField(String field) {
        Sort sort = Sort.by(field);
        List<Children> children = childrenRepo.findAll(sort);

        if (children.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(children, HttpStatus.OK);
    }

    public ResponseEntity<List<Children>> getPagination(int offset, int pagesize) {
        Pageable pg = PageRequest.of(offset, pagesize);
        return ResponseEntity.ok(childrenRepo.findAll(pg).getContent());
    }

    public ResponseEntity<List<Children>> getSortedPagination(int offset, int pagesize, String field) {
        Sort sort = Sort.by(field);
        Pageable pg = PageRequest.of(offset, pagesize, sort);
        return ResponseEntity.ok(childrenRepo.findAll(pg).getContent());
    }
}
