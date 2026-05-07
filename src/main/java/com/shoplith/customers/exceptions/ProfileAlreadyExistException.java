package com.shoplith.customers.exceptions;

public class ProfileAlreadyExistException extends  RuntimeException {

    public ProfileAlreadyExistException(String message){
        super(message);
    }

}
