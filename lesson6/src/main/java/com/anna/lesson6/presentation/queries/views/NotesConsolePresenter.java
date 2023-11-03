package com.anna.lesson6.presentation.queries.views;

import com.anna.lesson6.application.interfaces.NotesPresenter;
import com.anna.lesson6.domain.Note;

import java.util.Collection;

public class NotesConsolePresenter implements NotesPresenter {
    @Override
    public void printAll(Collection<Note> notes) {
        for (Note note : notes){
            System.out.println(note);
        }
    } 
    
    @Override
    public void printOne(Note note) {
        System.out.println(note);
    }

    @Override
    public void printMessage(String mes) {
        System.out.print(mes);
    }
}
