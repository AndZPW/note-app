package com.andzwp.noteservice.mappers;

import com.andzwp.noteservice.dao.NoteEntity;
import com.andzwp.noteservice.dto.Note;
import com.andzwp.userservice.dao.RoleEntity;
import com.andzwp.userservice.dao.UserEntity;
import com.andzwp.userservice.dto.Role;
import com.andzwp.userservice.dto.User;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class NoteMapper {

    public NoteEntity convertNoteToNoteEntity(@NonNull Note note) {
        var id = note.id();
        var content = note.content();
        var title = note.title();
        var userId = note.userId();

        return NoteEntity.builder()
                .id(id)
                .content(content)
                .title(title)
                .userId(userId)
                .build();
    }

    public Note convertNoteEntityToNote(@NonNull NoteEntity noteEntity) {
        var id = noteEntity.getId();
        var content = noteEntity.getContent();
        var title = noteEntity.getTitle();
        var userId = noteEntity.getUserId();

        return new Note(id, userId, title, content);
    }
}
