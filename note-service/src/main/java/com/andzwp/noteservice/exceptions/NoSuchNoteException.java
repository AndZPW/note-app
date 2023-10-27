package com.andzwp.noteservice.exceptions;

public class NoSuchNoteException extends Exception {
    public NoSuchNoteException() {
        super("No such note found");
    }
}
