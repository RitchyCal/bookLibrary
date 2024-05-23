package com.example.library;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import api.model.User;
import repo.UserRepository;
import service.UserService;

@Transactional
public class UserServiceTest {

    @Autowired
    UserRepository repo;

    UserService service;
   

    @org.junit.Before
    public void setUp() {

        repo = mock(UserRepository.class);
        service = new UserService(repo);
    }

    @Test
    public void getUser(){
        User sampleUser = new User();
        sampleUser.setId(1);
        sampleUser.setName("Ritchy");


        when(repo.findById(1)).thenReturn(sampleUser);
        User user = service.getUser(1);
        assertEquals("Ritchy", user.getName());
    }

    
}
