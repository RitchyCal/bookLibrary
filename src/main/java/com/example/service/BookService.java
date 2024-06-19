package com.example.service;

import com.example.api.model.response.BookDTO;
import com.example.exceptions.BookNotFoundException;
import com.example.mapper.BookDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repo.BookRepository;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookDTOMapper bookDTOMapper;

    @Autowired
    public BookService(BookRepository bookRepository, BookDTOMapper bookDTOMapper){
        this.bookRepository = bookRepository;
        this.bookDTOMapper = bookDTOMapper;
    }


    public BookDTO getBookByName (String name) throws BookNotFoundException {
        return bookRepository.findByTitle(name).map(bookDTOMapper).orElseThrow(()-> new BookNotFoundException(name));
    }

    public List<BookDTO> getBooksByGenre(String genre){
        return bookRepository.findAllByGenre(genre).stream().map(bookDTOMapper).toList();
    }
}
