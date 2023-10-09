package com.andzwp.noteservice.repositories;

import com.andzwp.noteservice.dao.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NoteRepository extends JpaRepository<NoteEntity, Integer> {

    Optional<NoteEntity> findNoteEntityByUserId(int userId);

    List<NoteEntity> findNoteEntitiesByUserId(int userId);

    void deleteNoteEntityByUserId(int userId);

}