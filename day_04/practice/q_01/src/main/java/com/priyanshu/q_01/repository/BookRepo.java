package com.priyanshu.q_01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.priyanshu.q_01.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {
}