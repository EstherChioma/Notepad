package com.notepad.application.Notepad.dto;


import com.notepad.application.Notepad.Model.Category;
import com.notepad.application.Notepad.Model.User;
import lombok.Data;

import javax.persistence.OneToOne;

@Data
public class NotePadDTO {

    private String name;

    private User user;

}
