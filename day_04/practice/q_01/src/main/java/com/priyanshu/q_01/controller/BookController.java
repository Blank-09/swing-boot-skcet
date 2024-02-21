package com.priyanshu.q_01.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.priyanshu.q_01.model.Book;
import com.priyanshu.q_01.service.BookService;

@RestController
@RequestMapping("api")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/book")
    @ResponseStatus(HttpStatus.CREATED)
    public Book getAllBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping("/book")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> list = bookService.getAllBooks();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable int bookId) {
        Optional<Book> book = bookService.getBookById(bookId);

        if (book.isPresent()) {
            return new ResponseEntity<>(book.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
