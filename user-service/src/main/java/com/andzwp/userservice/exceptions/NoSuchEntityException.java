package com.andzwp.userservice.exceptions;

public class NoSuchEntityException extends Exception{
    public NoSuchEntityException(){
        super("User not present");
    }
}
