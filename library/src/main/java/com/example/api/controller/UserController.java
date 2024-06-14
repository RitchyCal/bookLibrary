package com.example.api.controller;

import com.example.api.model.request.UserModel;
import com.example.api.model.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.example.api.model.User;
import com.example.service.UserService;

import java.util.Optional;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/{userId}")
    @ResponseBody
    public ResponseEntity<UserResponse> getUser(@PathVariable long userId){
        UserResponse response = new UserResponse();
        try {
            User user = userService.getUser(userId);
            response.setId(user.getUser_id());
            response.setUsername(user.getUsername());
        } catch (Exception error){
            System.out.println(error.toString());
        }

        return new ResponseEntity<>(response, HttpStatus.OK) ;
    }

    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(@RequestBody UserModel entity) {
        User user = new User();
        user.setFirstname(entity.getFirstname());
        user.setLastname(entity.getLastname());
        user.setPassword(entity.getPassword());
        user.setUsername(entity.getUsername());
        userService.createUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
