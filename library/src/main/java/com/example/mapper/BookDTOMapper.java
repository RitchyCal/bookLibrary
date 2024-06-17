package com.example.mapper;

import com.example.api.model.Book;
import com.example.api.model.response.BookDTO;
import com.example.api.model.response.UserDTO;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class BookDTOMapper implements Function<Book, BookDTO> {
    @Override
    public BookDTO apply( Book book){
        return new BookDTO(
                book.getTitle(),
                book.getAuthor(),
                book.getGenre()
        );
    }
}
