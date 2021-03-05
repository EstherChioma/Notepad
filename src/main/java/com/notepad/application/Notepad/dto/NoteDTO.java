package com.notepad.application.Notepad.dto;

import com.notepad.application.Notepad.Model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteDTO {

    private String title;

    private Category category;

    private String content;
}
