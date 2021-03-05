package com.notepad.application.Notepad.service.note;

import com.notepad.application.Notepad.Model.Note;
import com.notepad.application.Notepad.Model.Notepad;
import com.notepad.application.Notepad.Model.User;
import com.notepad.application.Notepad.dto.NoteDTO;
import com.notepad.application.Notepad.repository.NoteRepo;
import com.notepad.application.Notepad.repository.NotepadRepo;
import com.notepad.application.Notepad.repository.UserRepo;
import com.notepad.application.Notepad.service.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class NoteServiceImpl implements NoteService {

    @Autowired
    NoteRepo noteRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    NotepadRepo notepadRepo;


    @Override
    public Note save(NoteDTO noteDTO, Long notepadId)  throws NotepadNotFoundException {

        Notepad existingNotepad = notepadRepo.findNotepadById(notepadId);
        Note savedNote = null;
        if (existingNotepad != null) {

            Note note = new Note();
            note.setTitle(noteDTO.getTitle());
            note.setCategory(noteDTO.getCategory());
            note.setContent(noteDTO.getContent());

            // map notepad to notes
            existingNotepad.addNote(note);

            savedNote = noteRepo.save(note);

        }
        return savedNote;
    }

    @Override
    public List<Note> findAllNotes() {
        return noteRepo.findAll();
    }


}
