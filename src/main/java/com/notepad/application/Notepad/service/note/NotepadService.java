package com.notepad.application.Notepad.service.note;

import com.notepad.application.Notepad.dto.NotePadDTO;
import com.notepad.application.Notepad.Model.Note;

import java.util.List;

public interface NotepadService {

    Note addNote(NotePadDTO notePad);
    public List<Note>findAlLNotes ();
    public Note editNote(Note notePad, Long id);
    public Note editNote2(Note notePad, Long id);
    public void deleteNoteByNoteId(Long id);
    public Note selectNoteByNoteId(Long id);

}
