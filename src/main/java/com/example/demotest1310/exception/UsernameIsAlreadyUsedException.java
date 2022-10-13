package com.example.demotest1310.exception;

public class UsernameIsAlreadyUsedException extends RuntimeException{
    public UsernameIsAlreadyUsedException(String message) {
        super(message);
    }
}
