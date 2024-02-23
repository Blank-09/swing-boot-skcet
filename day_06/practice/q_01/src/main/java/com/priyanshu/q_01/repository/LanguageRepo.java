package com.priyanshu.q_01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.priyanshu.q_01.model.Language;

@Repository
public interface LanguageRepo extends JpaRepository<Language, Integer> {

}