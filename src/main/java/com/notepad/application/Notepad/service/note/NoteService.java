package com.notepad.application.Notepad.service.note;

import com.notepad.application.Notepad.Model.Note;
import com.notepad.application.Notepad.Model.Notepad;
import com.notepad.application.Notepad.dto.NoteDTO;
import com.notepad.application.Notepad.service.exception.UserNotFoundException;
import org.aspectj.weaver.ast.Not;

import java.util.List;

public interface NoteService {

    Note save(NoteDTO noteDTO, Long notepadId) throws NotepadNotFoundException;

    List<Note> findAllNotes();
}
