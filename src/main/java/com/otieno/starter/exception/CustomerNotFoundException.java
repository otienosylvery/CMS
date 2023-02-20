package com.otieno.starter.exception;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException (String message){
        super (message);
    }
}
