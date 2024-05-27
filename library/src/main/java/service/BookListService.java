package service;

import org.springframework.stereotype.Service;

import repo.BookListRepository;
import api.model.Book;
import java.util.List;

@Service
public class BookListService {
    private BookListRepository bookListRepository;

    public BookListService(BookListRepository bookListRepository){
        this.bookListRepository = bookListRepository;
    }

    public List<Book> getUserBooklist(int id){
            bookListRepository.findAllByUserId(id);
    }
}
