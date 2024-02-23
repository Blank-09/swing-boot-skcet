package com.priyanshu.q_01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priyanshu.q_01.model.Language;
import com.priyanshu.q_01.service.LanguageService;

@RestController
@RequestMapping("/api/language")
public class LanguageController {

    @Autowired
    private LanguageService languageService;

    @PostMapping
    public ResponseEntity<Language> addLanguage(@RequestBody Language language) {
        return languageService.addLanguage(language);
    }

    @GetMapping("/sortBy/{field}")
    public ResponseEntity<List<Language>> sortBy(@PathVariable String field) {
        return languageService.getSortedByField(field);
    }

    @GetMapping("/{offset}/{pagesize}")
    public ResponseEntity<List<Language>> getPagination(@PathVariable int offset,
            @PathVariable int pagesize) {
        return languageService.getPagination(offset, pagesize);
    }

    @GetMapping("/{offset}/{pagesize}/{field}")
    public ResponseEntity<List<Language>> getSortedPagination(@PathVariable int offset,
            @PathVariable int pagesize,
            @PathVariable String field) {
        return languageService.getSortedPagination(offset, pagesize, field);
    }

}
