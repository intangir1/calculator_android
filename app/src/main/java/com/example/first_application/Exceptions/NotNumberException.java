package com.example.first_application.Exceptions;

public class NotNumberException extends NumberFormatException{
    public NotNumberException(String errorMessage) {
        super(errorMessage);
    }
}
