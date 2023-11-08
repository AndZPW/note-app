package com.andzwp.userservice.exceptions;

public class EntityIsAlreadyCreatedException extends Exception {
    public EntityIsAlreadyCreatedException(){
        super("User is already");
    }
}
