package com.notepad.application.Notepad.service.notepad;

import com.notepad.application.Notepad.Model.Notepad;
import com.notepad.application.Notepad.dto.NotePadDTO;
import com.notepad.application.Notepad.Model.Note;
import com.notepad.application.Notepad.service.exception.UserNotFoundException;

import java.util.List;

public interface NotepadService {

    Notepad save(NotePadDTO notePad, Long userId) throws UserNotFoundException;

    public List<Notepad>findAlLNotePads ();

}
