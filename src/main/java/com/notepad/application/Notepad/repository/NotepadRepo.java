package com.notepad.application.Notepad.repository;

import com.notepad.application.Notepad.Model.Note;
import com.notepad.application.Notepad.Model.Notepad;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NotepadRepo extends JpaRepository<Notepad, Long>{

    Notepad findNotepadById(Long id);



}
