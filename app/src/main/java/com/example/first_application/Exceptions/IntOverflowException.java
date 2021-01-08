package com.example.first_application.Exceptions;

public class IntOverflowException extends ArithmeticException {
    public IntOverflowException(String errorMessage) {
        super(errorMessage);
    }
}
