package com.notepad.application.Notepad.dto;


import com.notepad.application.Notepad.Model.Category;
import lombok.Data;


public class NotePadDTO {

    private Category category;

    private String content;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
