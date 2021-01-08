package com.example.first_application.Exceptions;

public class DivideByZeroException extends ArithmeticException{
    public DivideByZeroException(String errorMessage) {
        super(errorMessage);
    }
}
