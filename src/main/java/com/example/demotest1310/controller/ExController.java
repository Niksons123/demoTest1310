package com.example.demotest1310.controller;

import com.example.demotest1310.exception.UserNotFoundException;
import com.example.demotest1310.exception.UsernameIsAlreadyUsedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExController extends ResponseEntityExceptionHandler {
    @ExceptionHandler
    protected ResponseEntity<?> catchPersonException(UserNotFoundException userNotFoundException){
        return new ResponseEntity<>(userNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    protected ResponseEntity<?> catchUsernameException(UsernameIsAlreadyUsedException usernameIsAlreadyUsedException){
        return new ResponseEntity<>(usernameIsAlreadyUsedException.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
