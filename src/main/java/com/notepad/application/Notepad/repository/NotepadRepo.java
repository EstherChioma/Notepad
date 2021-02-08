package com.notepad.application.Notepad.repository;

import com.notepad.application.Notepad.Model.Note;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NotepadRepo extends JpaRepository<Note, Long>{

    Note findNotepadById(Long id);



}
