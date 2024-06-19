package com.example.api.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private  String author;
    @Column(name = "genre")
    private String genre;
    
}
