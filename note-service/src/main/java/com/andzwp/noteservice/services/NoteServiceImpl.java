package com.andzwp.noteservice.services;

import com.andzwp.noteservice.dto.NoteDTO;
import com.andzwp.noteservice.dto.NoteRequest;
import com.andzwp.noteservice.exceptions.NoSuchNoteException;
import com.andzwp.noteservice.mappers.NoteMapper;
import com.andzwp.noteservice.repositories.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("default-service-impl")
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    private final NoteMapper noteMapper;

    public NoteServiceImpl(NoteRepository noteRepository, NoteMapper noteMapper) {
        this.noteRepository = noteRepository;
        this.noteMapper = noteMapper;
    }


    @Override
    public NoteDTO fetchNoteByUserId(int userId) throws NoSuchNoteException {
        var noteEntityOptional = noteRepository.findNoteEntityByUserId(userId);
        var noteEntity = noteEntityOptional.orElseThrow(NoSuchNoteException::new);
        return noteMapper.convertNoteEntityToNote(noteEntity);
    }

    @Override
    public NoteDTO createNote(NoteRequest noteRequest) {
        return null;
    }

    @Override
    public void deleteNoteByUserId(int userId) {

    }

    @Override
    public List<NoteDTO> fetchAll() {
        return noteRepository.findAll().stream()
                .map(noteMapper::convertNoteEntityToNote)
                .toList();
    }
}
