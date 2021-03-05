package com.notepad.application.Notepad.controller;

import com.notepad.application.Notepad.Model.Note;
import com.notepad.application.Notepad.Model.Notepad;
import com.notepad.application.Notepad.Model.User;
import com.notepad.application.Notepad.dto.NoteDTO;
import com.notepad.application.Notepad.repository.NotepadRepo;
import com.notepad.application.Notepad.repository.UserRepo;
import com.notepad.application.Notepad.service.exception.UserNotFoundException;
import com.notepad.application.Notepad.service.note.NoteService;
import com.notepad.application.Notepad.service.note.NotepadNotFoundException;
import com.notepad.application.Notepad.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    NoteService noteService;

    @Autowired
    NotepadRepo notepadRepo;


    @PostMapping("/note/{notepadId}")
    ResponseEntity<Note> saveNote(@RequestBody NoteDTO noteDTO, @PathVariable Long notepadId) throws NotepadNotFoundException {

        Notepad existingNotepad = notepadRepo.findNotepadById(notepadId);

        Note note1 = noteService.save(noteDTO,notepadId);

        return new ResponseEntity<>(note1, HttpStatus.CREATED);

    }


    @GetMapping("/notes/{notepadId}")
    List<Note> findAll(@PathVariable Long notepadId){

        return noteService.findAllNotes();
    }

}
