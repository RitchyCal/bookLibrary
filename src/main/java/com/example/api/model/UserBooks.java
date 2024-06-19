package com.example.api.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "userbooks")
@NoArgsConstructor
public class UserBooks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userBookId;
    @Column(name = "user_id")
    private Long user_id;
    @Column(name = "book_id")
    private Long book_id;
    @Column(name = "readdate")
    private Date readDate;
    @Column(name = "list_id")
    private Long listId;
}
