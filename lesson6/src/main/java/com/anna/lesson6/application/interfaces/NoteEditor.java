package com.anna.lesson6.application.interfaces;

import com.anna.lesson6.domain.Note;

public interface NoteEditor extends Editor<Note, Integer>{

    void printAll();
    void printOne(Note note);
    void printMessage(String mes);

}
