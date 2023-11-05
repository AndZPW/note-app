package com.andzwp.noteservice.repositories;

import com.andzwp.noteservice.dao.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Integer> {

    Optional<Note> findNoteEntityByUserId(int userId);

    List<Note> findNoteEntitiesByUserId(int userId);

    void deleteNoteEntityByUserId(int userId);

}