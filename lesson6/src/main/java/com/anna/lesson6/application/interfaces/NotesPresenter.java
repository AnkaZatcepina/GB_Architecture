package com.anna.lesson6.application.interfaces;

import com.anna.lesson6.domain.Note;

import java.util.Collection;

public interface NotesPresenter {

    void printAll(Collection<Note> notes);
    void printOne(Note note);
    void printMessage(String mes);
}
