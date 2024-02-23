package com.priyanshu.q_01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priyanshu.q_01.model.Children;
import com.priyanshu.q_01.service.ChildrenService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/children")
public class ChildrenController {

    @Autowired
    private ChildrenService childrenService;

    @PostMapping
    public ResponseEntity<Children> addChild(@RequestBody Children child) {
        return childrenService.addChild(child);
    }

    @GetMapping("/sortBy/{field}")
    public ResponseEntity<List<Children>> sortBy(@PathVariable String field) {
        return childrenService.getSortedChildrenByField(field);
    }

    @GetMapping("/{offset}/{pagesize}")
    public ResponseEntity<List<Children>> getPagination(@PathVariable int offset,
            @PathVariable int pagesize) {
        return childrenService.getPagination(offset, pagesize);
    }

    @GetMapping("/{offset}/{pagesize}/{field}")
    public ResponseEntity<List<Children>> getSortedPagination(@PathVariable int offset,
            @PathVariable int pagesize,
            @PathVariable String field) {
        return childrenService.getSortedPagination(offset, pagesize, field);
    }

}