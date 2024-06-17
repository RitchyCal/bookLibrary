package com.example.exceptions;

public class BookNotFoundException extends Exception{
    public  BookNotFoundException(){
        super("Book not found");
    }
    public  BookNotFoundException(String name){
        super("Book" + name +" not found");
    }
}
