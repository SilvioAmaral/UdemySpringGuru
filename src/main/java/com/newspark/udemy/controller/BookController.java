package com.newspark.udemy.controller;

import com.newspark.udemy.domain.Book;
import com.newspark.udemy.service.BookServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BookController {

    public final BookServiceImpl bookService;

    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/books")
    public Iterable<Book> getBooks() {
        return bookService.findAll();
    }
}
