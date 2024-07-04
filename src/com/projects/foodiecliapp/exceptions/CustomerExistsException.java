package com.projects.foodiecliapp.exceptions;

public class CustomerExistsException extends Exception{
    public CustomerExistsException(String message) {
        super(message);
    }
}
