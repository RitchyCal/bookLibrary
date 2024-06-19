package com.example.api.controller;

import com.example.api.model.UserBooks;
import com.example.service.UserBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/userBooks/v1")
public class UserBookController {

    private final UserBookService userBookService;

    @Autowired
    public UserBookController(UserBookService userBookService) {
        this.userBookService = userBookService;
    }

    @PostMapping()
    public void addBook(UserBooks books){
        userBookService.addBook(books);
    }
}
