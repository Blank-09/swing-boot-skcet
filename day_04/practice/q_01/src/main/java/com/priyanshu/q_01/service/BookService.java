package com.priyanshu.q_01.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priyanshu.q_01.model.Book;
import com.priyanshu.q_01.repository.BookRepo;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public Optional<Book> getBookById(int id) {
        return bookRepo.findById(id);
    }

    public Book addBook(Book user) {
        return bookRepo.save(user);
    }

}