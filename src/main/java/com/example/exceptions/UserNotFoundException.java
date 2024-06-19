package com.example.exceptions;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(Long id){
        super("User with id: " + id + " was not found.");
    }
}
