package com.example.demo.models.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(Long id) {
        super(String.format("Book with id %d does not exist",id));
    }
}