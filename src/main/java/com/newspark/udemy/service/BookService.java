package com.newspark.udemy.service;

import com.newspark.udemy.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}
