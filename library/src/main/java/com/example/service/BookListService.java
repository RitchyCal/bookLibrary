package com.example.service;

import com.example.api.model.BookList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repo.BookListRepository;
import com.example.api.model.Book;
import java.util.List;

@Service
public class BookListService {
    private final BookListRepository bookListRepository;

    @Autowired
    public BookListService(BookListRepository bookListRepository){
        this.bookListRepository = bookListRepository;
    }

    public List<Book> getUserBooklist(int id){
        List<BookList> books =  bookListRepository.findAllByUserId(id);
        return List.of();
    }
}
