package com.andzwp.noteservice.services;

import com.andzwp.noteservice.dto.Note;
import com.andzwp.noteservice.dto.NoteRequest;
import com.andzwp.noteservice.exceptions.NoSuchNoteException;

import java.util.List;

public interface NoteService {

    Note fetchNoteByUserId(int userId) throws NoSuchNoteException;

    Note createNote(NoteRequest noteRequest);

    void deleteNoteByUserId(int userId);

    List<Note> fetchAll();
}
