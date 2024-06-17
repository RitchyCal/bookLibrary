package com.example.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.api.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository  extends JpaRepository<Book, Integer> {

    Optional<Book> findByTitle(String title);

    List<Book> findAllByGenre (String genre);
}
