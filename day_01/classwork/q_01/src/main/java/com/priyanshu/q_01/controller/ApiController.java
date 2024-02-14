package com.priyanshu.q_01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @GetMapping("/welcome")
        public String ReturnString() {
            return "Welcome Spring Boot!";
        }
}