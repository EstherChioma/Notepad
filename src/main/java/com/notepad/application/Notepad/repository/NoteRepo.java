package com.notepad.application.Notepad.repository;

import com.notepad.application.Notepad.Model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepo extends JpaRepository<Note,Long> {

    Note findNoteById(Long id);
}
