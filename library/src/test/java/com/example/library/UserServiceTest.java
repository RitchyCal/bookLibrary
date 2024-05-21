package com.example.library;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import api.model.User;
import repo.UserRepository;
import service.UserService;

@Transactional
public class UserServiceTest {

    @Autowired
    UserRepository repo;

    UserService service = new UserService(repo);
    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setName("Ritchy");
        user.setId(1);
    }
}
