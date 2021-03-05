package com.notepad.application.Notepad.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Notepad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(fetch = FetchType.EAGER)
    private User user;

    @CreationTimestamp
    private Date dateCreated;

    @OneToMany
    private List<Note> noteCollection;

    // adding a note to note collection
    public void addNote(Note note){

        if(noteCollection == null){
            noteCollection = new ArrayList<>();
        }
        noteCollection.add(note);
    }
}
