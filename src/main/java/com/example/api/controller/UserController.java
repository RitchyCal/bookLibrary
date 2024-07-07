package com.example.api.controller;

import com.example.api.model.request.UserModel;
import com.example.api.model.response.UserDTO;
import com.example.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


import com.example.api.model.User;
import com.example.service.UserService;
import org.springframework.web.client.HttpClientErrorException;


@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/{userId}")
    @ResponseBody
    public ResponseEntity<UserDTO> getUser(@PathVariable long userId) throws UserNotFoundException {
        UserDTO response = userService.getUser(userId);

        return new ResponseEntity<>(response, HttpStatus.OK) ;
    }

    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(@RequestBody UserModel entity) {
        userService.createUser(entity);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
