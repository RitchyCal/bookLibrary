package com.example.api.model;

import jakarta.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "BookList")
public class BookList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userId;
    private String bookname;
    private int bookId;
}
