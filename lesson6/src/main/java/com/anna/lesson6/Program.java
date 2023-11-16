package com.anna.lesson6;

import com.anna.lesson6.application.ConcreteNoteEditor;
import com.anna.lesson6.application.interfaces.NoteEditor;
import com.anna.lesson6.application.interfaces.NotesDatabaseContext;
import com.anna.lesson6.database.NotesDatabase;
import com.anna.lesson6.infrastructure.persistance.Database;
import com.anna.lesson6.infrastructure.persistance.DatabaseContext;
import com.anna.lesson6.presentation.queries.controllers.NotesController;
import com.anna.lesson6.presentation.queries.views.NotesConsolePresenter;

public class Program {

    /**
     * CQRS
     * @param args
     */
    public static void main(String[] args) {
        Database database = new NotesDatabase();
        NotesDatabaseContext context = new DatabaseContext(database);
        NotesConsolePresenter notesConsolePresenter = new NotesConsolePresenter();
        NoteEditor noteEditor = new ConcreteNoteEditor(notesConsolePresenter, context);

        NotesController notesController = new NotesController(noteEditor);

        notesController.routeGetAll();
        notesController.deleteNoteByTitle("title #3");
        notesController.routeGetAll();
    }

}
