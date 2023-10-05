package com.andzwp.userservice.exceptions;

public class UserIsAlreadyCreatedException extends Exception {
    public UserIsAlreadyCreatedException(){
        super("User is already");
    }
}
