package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.model.User;
import com.example.repo.UserRepository;

@Service
public class UserService {
    // will be a db call to get user
   @Autowired
    UserRepository userRepository;

    public User getUser(long id) {
        return userRepository.findByUserId(id);
    }
    public void createUser(User entity) {
        userRepository.save(entity);
    }

}
