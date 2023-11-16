package com.anna.lesson6.presentation.queries.controllers;

import java.util.Optional;

import org.w3c.dom.Node;

import com.anna.lesson6.application.interfaces.NoteEditor;
import com.anna.lesson6.domain.Note;
import com.anna.lesson6.presentation.queries.controllers.Controller;

public class NotesController extends Controller {

    private final NoteEditor noteEditor;

    public NotesController(NoteEditor noteEditor) {
        this.noteEditor = noteEditor;
    }

    //TODO: \notes\all
    public void routeGetAll(){
        noteEditor.printAll();
    }

    public void deleteNoteByTitle(String title){
        Optional opt = noteEditor.getByTitle(title);
        if (opt.isPresent()) {
            Note note = (Note)opt.get();
            if (noteEditor.remove(note)){
                noteEditor.printMessage("Запись удалена: ");
                noteEditor.printOne(note);
            } else {
                noteEditor.printMessage("Ошибка удаления записи: ");
                noteEditor.printOne(note);
            }
        } else {
            noteEditor.printMessage("Запись не найдена: ");
        }
    }


}
