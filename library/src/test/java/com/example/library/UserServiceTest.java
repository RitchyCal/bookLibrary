package com.example.library;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.api.model.response.UserDTO;
import com.example.exceptions.UserNotFoundException;
import com.example.mapper.UserDTOMapper;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Before;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.api.model.User;
import com.example.repo.UserRepository;
import com.example.service.UserService;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    UserRepository repo;
    @Autowired
    UserService service;
    @Autowired
    UserDTOMapper mapper = new UserDTOMapper();
    @Rule
    public  final ExpectedException  exception = ExpectedException.none();
   

    @Before
    public void setUp() {
        service = new UserService(repo, mapper);

    }
    User sampleUser = new User();
    @Test
    public void getUserHappyPath() throws UserNotFoundException {

        sampleUser.setUser_id(1);
        sampleUser.setFirstname("Ritchy");


        when(repo.findByUserid(1)).thenReturn(Optional.ofNullable(sampleUser));
        UserDTO expected = mapper.apply(sampleUser);
        // When
        UserDTO user = service.getUser(1);
        assertEquals(user, expected);
    }

    @Test
    public void getUserNotFound() throws UserNotFoundException {
        when(repo.findByUserid(0)).thenReturn(null);
        service.getUser(1);
    }


    
}
