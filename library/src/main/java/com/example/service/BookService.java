package com.example.service;

import org.springframework.stereotype.Service;
import com.example.api.model.Book;

import com.example.repo.BookRepository;

@Service
public class BookService {
    BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public Book getBookByName (String name){
        return bookRepository.findByBookName(name);
    }
}
