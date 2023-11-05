package com.andzwp.noteservice.mappers;

import com.andzwp.noteservice.dao.Note;
import com.andzwp.noteservice.dto.NoteDTO;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NoteMapper {


    private final ModelMapper modelMapper;

    public NoteMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Note convertNoteDTOToNote(@NonNull NoteDTO noteDTO) {
        return modelMapper.map(noteDTO, Note.class);
    }

    public NoteDTO convertNoteToNoteDTO(@NonNull Note note) {
        return modelMapper.map(note, NoteDTO.class);
    }
}
