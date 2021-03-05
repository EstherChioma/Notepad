package com.notepad.application.Notepad.service.notepad;

import com.notepad.application.Notepad.Model.Note;
import com.notepad.application.Notepad.Model.Notepad;
import com.notepad.application.Notepad.Model.User;
import com.notepad.application.Notepad.dto.NotePadDTO;
import com.notepad.application.Notepad.repository.NotepadRepo;
import com.notepad.application.Notepad.repository.UserRepo;
import com.notepad.application.Notepad.service.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class NotepadServiceImpl implements NotepadService {

    @Autowired
    NotepadRepo notepadRepo;

    @Autowired
    UserRepo userRepo;

    @Override
    @Transactional
    public Notepad save(NotePadDTO notePad, Long userId) throws UserNotFoundException {


        User existingUser = userRepo.findUserById(userId);

            Notepad notepad = new Notepad();
            notePad.setName(notePad.getName());

            // map user to the notepad
            existingUser.setNotepad(notepad);

           Notepad savedNotePad = notepadRepo.save(notepad);


        return savedNotePad;

    }

    @Override
    public List<Notepad> findAlLNotePads() {
        return notepadRepo.findAll();
    }
}
