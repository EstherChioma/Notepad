package com.notepad.application.Notepad.controller;

import com.notepad.application.Notepad.Model.Notepad;
import com.notepad.application.Notepad.Model.User;
import com.notepad.application.Notepad.dto.NotePadDTO;
import com.notepad.application.Notepad.Model.Note;
import com.notepad.application.Notepad.repository.UserRepo;
import com.notepad.application.Notepad.service.exception.UserNotFoundException;
import com.notepad.application.Notepad.service.notepad.NotepadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RequestMapping("/api/notepads")
@RestController
public class NotePadController {

    @Autowired
    NotepadService notepadService;

    @Autowired
    UserRepo userRepo;

    @PostMapping("/notepad/{userId}")
    ResponseEntity<Notepad> saveNotepad(@RequestBody NotePadDTO notepad, @PathVariable Long userId) throws UserNotFoundException {

        User existingUser = userRepo.findUserById(userId);

        Notepad savedNotePad = notepadService.save(notepad, userId);

        return new ResponseEntity<>(savedNotePad, HttpStatus.CREATED);
    }

    @GetMapping("/notePads/{userId}")
    public List<Notepad> findAllNotePad(@PathVariable Long userId){

        return notepadService.findAlLNotePads();
    }


}






















