package com.home.practice.jpa.exception;

public class ContactNotFoundException extends RuntimeException { 

    public ContactNotFoundException(String id) {
        super("The id '" + id + "' does not exist in our records");
    }
    
}
