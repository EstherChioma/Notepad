package com.notepad.application.Notepad.controller;

import com.notepad.application.Notepad.dto.NotePadDTO;
import com.notepad.application.Notepad.Model.Note;
import com.notepad.application.Notepad.service.NotepadServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/notepads")
@RestController
public class Controller {


    private NotepadServiceImplementation notepadServiceImpl;


    @Autowired
    public Controller(NotepadServiceImplementation notepadServiceImpl) {
        this.notepadServiceImpl = notepadServiceImpl;

    }

    // save a note
    @PostMapping("/save")
    public Note saveNotepad(@RequestBody NotePadDTO notepad){
        return  notepadServiceImpl.addNote(notepad);
    }


    // get all note
    @GetMapping("/getall")
    public List<Note> getAllNotpad(){

        return notepadServiceImpl.findAlLNotes();
    }

    // edit a notepad
    @PutMapping("/{id}")
    public Note updateNotepad(@PathVariable Long id, @RequestBody Note notepad){

        return notepadServiceImpl.editNote(notepad, id);
    }

    // delete a particlar notepad
    @DeleteMapping("/{id}")
    public void deleteNotepad(@PathVariable Long id){
        notepadServiceImpl.deleteNoteByNoteId(id);
    }

    // find a particlar notepad
    @GetMapping("/{id}")
    public Note findANote(@PathVariable Long id){
        return notepadServiceImpl.selectNoteByNoteId(id);
    }
}






















