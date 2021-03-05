//package com.notepad.application.Notepad.repository;
//
//import com.notepad.application.Notepad.Model.Category;
//import com.notepad.application.Notepad.Model.Note;
//import com.notepad.application.Notepad.Model.User;
//import com.notepad.application.Notepad.service.user.UserServiceImpl;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import javax.management.relation.Role;
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Optional;
//import java.util.logging.Logger;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//class NotepadRepoTest {
//
//    Logger log = Logger.getLogger(getClass().getName());
//
//    @Autowired
//    NotepadRepo notepadRepo;
//    UserRepo userRepo;
//
//
//    @BeforeEach
//    void setUp() {
//
//    }
//
//
//    @Test
//    void saveNotepad() {
//        Note notepad = new Note();
//        notepad.setCategory(Category.PERSONAL);
//        notepad.setContent("buy food");
//
//        notepadRepo.save(notepad);
//
//        assertThat(notepad).isNotNull();
//    }
//
//
//    @Test
//    void getAllNotepad() {
//
//        List<Note> notepadList = notepadRepo.findAll();
//        assertThat(notepadList).isNotNull();
//
//        log.info("list of all note -> {}" + notepadList);
//
//
//    }
//
//    @Test
//    void updateNotepad() {
//
//        Note existingNote = notepadRepo.findNotepadById(1L);
//        existingNote.setContent("good food");
//        existingNote.setCategory(Category.TRAVEL);
//
//        notepadRepo.save(existingNote);
//
//        assertThat(existingNote.getContent()).isEqualTo("good food");
//        log.info("updated note is -> {}" + existingNote);
//    }
//
//    @Test
//    void deleteNotepad() {
//        Note notepad = new Note();
//        notepad.setCategory(Category.PERSONAL);
//        notepad.setContent("buy food");
//
//        notepadRepo.save(notepad);
//
//        Note notepad2 = new Note();
//        notepad2.setCategory(Category.PERSONAL);
//        notepad2.setContent("buy food");
//
//        Note savedNotePad = notepadRepo.save(notepad2);
//        System.out.println(savedNotePad.toString());
//
//        notepadRepo.delete(savedNotePad);
//        assertNull(notepadRepo.findNotepadById(savedNotePad.getId()));
//
//    }
//
//
//
//
//
//
////    User FindUserbyEmail(String userRepo) {
////
////        Assertions.assertEquals(new User(null, "firstName", "lastName", "email", "password", Role.USER, new HashSet<Note>(Arrays.asList(new Note(Long.valueOf(1), "title", "body", null, new Category(Long.valueOf(1), "name", "description", "password", Arrays.<Note>asList(null), null), new HashSet<User>(Arrays.asList(null)))))), result);
//    }
//
//
//
//
//
