package com.anna.lesson6.application;

import com.anna.lesson6.application.interfaces.NoteEditor;
import com.anna.lesson6.application.interfaces.NotesDatabaseContext;
import com.anna.lesson6.application.interfaces.NotesPresenter;
import com.anna.lesson6.domain.Note;

import java.util.Collection;
import java.util.Optional;

public class ConcreteNoteEditor implements NoteEditor {

    private final NotesDatabaseContext dbContext;
    private final NotesPresenter presenter;

    public ConcreteNoteEditor(
            NotesPresenter presenter,
            NotesDatabaseContext dbContext) {
        this.dbContext = dbContext;
        this.presenter = presenter;
    }

    @Override
    public boolean add(Note item) {
        dbContext.getAll().add(item);
        return dbContext.saveChanges();
    }

    @Override
    public boolean edit(Note item) {
        return false;
    }

    @Override
    public boolean remove(Note item) {
        dbContext.getAll().remove(item);
        return dbContext.saveChanges();
    }

    @Override
    public Optional<Note> getById(Integer integer) {      
        return Optional.empty();        
    }    
    
    @Override
    public Optional<Note> getByTitle(String title) {
        Note note = dbContext.getByTitle(title);
        if (note == null){
            return Optional.empty();
        }
        return Optional.of(note);
        
    }

    @Override
    public Collection<Note> getAll() {
        return dbContext.getAll();
    }

    @Override
    public void printAll() {
        presenter.printAll(getAll());
    }   
    
    @Override
    public void printOne(Note note) {
        presenter.printOne(note);
    }    
    
    @Override
    public void printMessage(String mes) {
        presenter.printMessage(mes);
    }

}
