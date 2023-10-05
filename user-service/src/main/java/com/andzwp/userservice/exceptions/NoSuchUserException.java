package com.andzwp.userservice.exceptions;

public class NoSuchUserException extends Exception{
    public NoSuchUserException(){
        super("User not present");
    }
}
