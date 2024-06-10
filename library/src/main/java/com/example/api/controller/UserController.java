package com.example.api.controller;

import com.example.api.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.example.api.model.User;
import com.example.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    @ResponseBody
    public User getUser(@PathVariable int id){

        return userService.getUser(id);
    }

    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(@RequestBody UserModel entity) {
        User user = new User();
        user.setFirstname(entity.getFirstname());
        user.setLastname(entity.getLastname());
        user.setPassword(entity.getPassword());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    
}
