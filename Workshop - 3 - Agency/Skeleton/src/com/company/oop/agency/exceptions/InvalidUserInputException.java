package com.company.oop.agency.exceptions;

public class InvalidUserInputException extends RuntimeException {

    public InvalidUserInputException() {
    }

    public InvalidUserInputException(String message) {
        super(message);
    }

}
