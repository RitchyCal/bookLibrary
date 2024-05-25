package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import api.model.Book;

import repo.BookRepository;

@Service
public class BookService {
    BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooksByGenre(String genre){
       List<Book> bookList = new ArrayList<>();

       return bookList;
    }

    public Book getBookByName (String name){
        return bookRepository.findByBookName(name);
    }
}
