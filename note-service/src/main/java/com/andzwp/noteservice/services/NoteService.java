package com.andzwp.noteservice.services;

import com.andzwp.noteservice.dto.NoteDTO;
import com.andzwp.noteservice.dto.NoteRequest;
import com.andzwp.noteservice.exceptions.NoSuchNoteException;

import java.util.List;

public interface NoteService {

    NoteDTO fetchNoteByUserId(int userId) throws NoSuchNoteException;

    NoteDTO createNote(NoteRequest noteRequest);

    void deleteNoteByUserId(int userId);

    List<NoteDTO> fetchAll();
}
