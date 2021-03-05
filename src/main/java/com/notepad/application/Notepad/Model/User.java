package com.notepad.application.Notepad.Model;

import com.notepad.application.Notepad.dto.NoteDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @OneToOne(fetch = FetchType.EAGER)
    private Notepad notepad;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Note> listOfNotes;

    private String email;

    private String password;

    private String phoneNumber;

    @CreationTimestamp
    private Date dateCreated;

    // adding a note to list of notes
    public void addNote(Note note){

        if(listOfNotes == null){
            listOfNotes = new ArrayList<>();
        }
        listOfNotes.add(note);
    }

}
