package com.andzwp.noteservice.controllers;

import com.andzwp.noteservice.services.NoteService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteController {

    @Qualifier("default-service-impl")
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }
}
