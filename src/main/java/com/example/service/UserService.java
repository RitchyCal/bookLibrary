package com.example.service;

import com.example.api.model.request.UserModel;
import com.example.api.model.response.UserDTO;
import com.example.exceptions.UserNotFoundException;
import com.example.mapper.UserDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.api.model.User;
import com.example.repo.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserDTOMapper userDTOMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserDTOMapper userDTOMapper) {
        this.userRepository = userRepository;
        this.userDTOMapper = userDTOMapper;
    }

    public UserDTO getUser(long id) throws UserNotFoundException {
        return userRepository.findByUserid(id).map(userDTOMapper).orElseThrow(() ->new  UserNotFoundException(id));
    }
    public void createUser(UserModel entity) {
        User user = new User();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(entity.getPassword());
        user.setFirstname(entity.getFirstname());
        user.setLastname(entity.getLastname());
        user.setPassword(hashedPassword);
        user.setUsername(entity.getUsername());
        userRepository.save(user);
    }

}
