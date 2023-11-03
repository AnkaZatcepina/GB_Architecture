package com.anna.lesson6.presentation.queries.controllers;

import com.anna.lesson6.application.interfaces.NoteEditor;
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


}
