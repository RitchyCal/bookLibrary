package com.example.api.controller;

import com.example.api.model.Book;
import com.example.api.model.response.BookDTO;
import com.example.exceptions.BookNotFoundException;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/{name}")
    public ResponseEntity<BookDTO> getBookByName(@PathVariable String name) throws BookNotFoundException {

        BookDTO response = bookService.getBookByName(name);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/{name}")
    public ResponseEntity<List<BookDTO>> getBooksByGenre(@PathVariable String genre) throws BookNotFoundException {

        List<BookDTO> response = bookService.getBooksByGenre(genre);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
