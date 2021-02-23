package com.notepad.application.Notepad.controller;

import com.notepad.application.Notepad.dto.NotePadDTO;
import com.notepad.application.Notepad.Model.Note;
import com.notepad.application.Notepad.service.note.NotepadServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/notepads")
@RestController
public class Controller {

    //@Todo you need to update this controller now that you have users.


    private NotepadServiceImplementation notepadServiceImpl;


    @Autowired
    public Controller(NotepadServiceImplementation notepadServiceImpl) {
        this.notepadServiceImpl = notepadServiceImpl;

    }

    //@Todo If i save a note, let it the note be saved as mine.
    // save a note
    @PostMapping("/save")
    public Note saveNotepad(@RequestBody NotePadDTO notepad){
        return  notepadServiceImpl.addNote(notepad);
    }


    // get all note
    //@Todo I should only be able to get the notes i saved not all the note on the db
    @GetMapping("/getall")
    public List<Note> getAllNotpad(){

        return notepadServiceImpl.findAlLNotes();
    }

    // edit a notepad
    //@Todo I should be able to update my note and not your own note.
    @PutMapping("/{id}")
    public Note updateNotepad(@PathVariable Long id, @RequestBody Note notepad){

        return notepadServiceImpl.editNote(notepad, id);
    }

    // delete a particlar notepad
    //@Todo I should be able to delete my own note but i should get an error when i try to delete yours
    @DeleteMapping("/{id}")
    public void deleteNotepad(@PathVariable Long id){
        notepadServiceImpl.deleteNoteByNoteId(id);
    }


    //@Todo I should be able to get only my notes even if i have an id.
    // find a particlar notepad
    @GetMapping("/{id}")
    public Note findANote(@PathVariable Long id){
        return notepadServiceImpl.selectNoteByNoteId(id);
    }
}






















