package com.company.oop.cosmetics.exceptions;

public class InvalidUserInputException extends RuntimeException {
    public InvalidUserInputException(String message) {
        super(message);
    }
}
