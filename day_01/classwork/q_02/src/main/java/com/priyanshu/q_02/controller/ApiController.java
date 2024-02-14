package com.priyanshu.q_02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping("/studentName")
    public String ReturnString(@RequestParam String studentName) {
        return "Welcome " + studentName + "!";
    }

}
