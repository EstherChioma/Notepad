package com.notepad.application.Notepad.service.note;

import com.notepad.application.Notepad.dto.NotePadDTO;
import com.notepad.application.Notepad.Model.Note;
import com.notepad.application.Notepad.repository.NotepadRepo;
import com.notepad.application.Notepad.service.note.NotepadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotepadServiceImplementation implements NotepadService {

    @Autowired
    private NotepadRepo notepadRepo;


    @Override
    public Note addNote(NotePadDTO notePad) {

        Note notepad = new Note();
        notepad.setCategory(notePad.getCategory());
        notepad.setContent(notePad.getContent());

        notepad = notepadRepo.save(notepad);
        return notepad;


    }


    @Override
    public List<Note> findAlLNotes() {
        return notepadRepo.findAll();
    }

    @Override
    public Note editNote(Note notePad, Long id) {
        Note existingNotepad = notepadRepo.findNotepadById(id);

        existingNotepad.setContent(notePad.getContent());
        existingNotepad.setCategory(notePad.getCategory());

        notepadRepo.save(existingNotepad);

        return existingNotepad;
    }

    @Override
    public Note editNote2(Note notePad, Long id) {

        Note existingNotepad = notepadRepo.findNotepadById(id);
        existingNotepad.setContent(notePad.getContent());

        return existingNotepad;
    }

    @Override
    public void deleteNoteByNoteId(Long id) {
        Note existingNotepad = notepadRepo.findNotepadById(id);

        notepadRepo.delete(existingNotepad);

    }

    @Override
    public Note selectNoteByNoteId(Long id) {
        Note existingNotepad = notepadRepo.findNotepadById(id);

        return existingNotepad;
    }
}
