package com.andzwp.noteservice.services;

import com.andzwp.noteservice.dto.Note;
import com.andzwp.noteservice.dto.NoteRequest;

public interface NoteService {

    Note fetchNoteByUserId(int userId);

    Note createNote(NoteRequest noteRequest);

    void deleteNoteByUserId(int userId);


}
