package com.develcode.backend.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("Não foi encontrado usuario com esse id " + id);
    }
}