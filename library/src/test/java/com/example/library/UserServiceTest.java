package com.example.library;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.api.model.User;
import com.example.repo.UserRepository;
import com.example.service.UserService;

@Transactional
public class UserServiceTest {

    @Autowired
    UserRepository repo;
    @Autowired
    UserService service;
   

    @org.junit.Before
    public void setUp() {

        repo = mock(UserRepository.class);
        service = new UserService();

    }
    User sampleUser = new User();
    @Test
    public void getUser(){

        sampleUser.setUser_id(1);
        sampleUser.setFirstname("Ritchy");


        when(repo.findByUserId(1)).thenReturn(sampleUser);
        User user = service.getUser(1);
        assertEquals("Ritchy", user.getFirstname());
    }

    
}
