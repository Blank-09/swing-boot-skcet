package com.priyanshu.q_01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.priyanshu.q_01.repository.LanguageRepo;
import com.priyanshu.q_01.model.Language;

@Service
public class LanguageService {

    @Autowired
    private LanguageRepo languageRepo;

    public ResponseEntity<Language> addLanguage(Language language) {
        return new ResponseEntity<>(languageRepo.save(language), HttpStatus.CREATED);
    }

    public ResponseEntity<List<Language>> getSortedByField(String field) {
        Sort sort = Sort.by(field);
        List<Language> language = languageRepo.findAll(sort);

        if (language.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(language, HttpStatus.OK);
    }

    public ResponseEntity<List<Language>> getPagination(int offset, int pagesize) {
        Pageable pg = PageRequest.of(offset, pagesize);
        return ResponseEntity.ok(languageRepo.findAll(pg).getContent());
    }

    public ResponseEntity<List<Language>> getSortedPagination(int offset, int pagesize, String field) {
        Sort sort = Sort.by(field);
        Pageable pg = PageRequest.of(offset, pagesize, sort);
        return ResponseEntity.ok(languageRepo.findAll(pg).getContent());
    }

}
