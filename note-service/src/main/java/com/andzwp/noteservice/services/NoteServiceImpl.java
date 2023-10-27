package com.andzwp.noteservice.services;

import com.andzwp.noteservice.dto.Note;
import com.andzwp.noteservice.dto.NoteRequest;
import com.andzwp.noteservice.exceptions.NoSuchNoteException;
import com.andzwp.noteservice.mappers.NoteMapper;
import com.andzwp.noteservice.repositories.NoteRepository;

import java.util.List;

public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    private final NoteMapper noteMapper;

    public NoteServiceImpl(NoteRepository noteRepository, NoteMapper noteMapper) {
        this.noteRepository = noteRepository;
        this.noteMapper = noteMapper;
    }


    @Override
    public Note fetchNoteByUserId(int userId) throws NoSuchNoteException {
        var noteEntityOptional = noteRepository.findNoteEntityByUserId(userId);
        var noteEntity = noteEntityOptional.orElseThrow(NoSuchNoteException::new);
        return noteMapper.convertNoteEntityToNote(noteEntity);
    }

    @Override
    public Note createNote(NoteRequest noteRequest) {
        return null;
    }

    @Override
    public void deleteNoteByUserId(int userId) {

    }

    @Override
    public List<Note> fetchAll() {
        return noteRepository.findAll().stream()
                .map(noteMapper::convertNoteEntityToNote)
                .toList();
    }
}
