package service;

import org.springframework.stereotype.Service;

import repo.BookListRepository;

@Service
public class BookListService {
    private BookListRepository bookListRepository;

    public BookListService(BookListRepository bookListRepository){
        this.bookListRepository = bookListRepository;
    }
}
