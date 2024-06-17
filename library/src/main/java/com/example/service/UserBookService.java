package com.example.service;

import com.example.api.model.UserBooks;
import com.example.repo.UserBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBookService {
    private final UserBooksRepository userBooksRepository;
    @Autowired
    public UserBookService(UserBooksRepository userBooksRepository) {
        this.userBooksRepository = userBooksRepository;
    }

    public void addBook(UserBooks userBooks){
        userBooksRepository.save(userBooks);
    }
}
