package com.anna.lesson6.infrastructure.persistance;

import com.anna.lesson6.application.interfaces.NotesDatabaseContext;
import com.anna.lesson6.database.NotesDatabase;
import com.anna.lesson6.database.NotesRecord;
import com.anna.lesson6.domain.Note;
import com.anna.lesson6.infrastructure.persistance.entityconfiguration.NoteConfiguration;

import java.util.ArrayList;
import java.util.Collection;

public class DatabaseContext extends DbContext implements NotesDatabaseContext {

    public Collection<Note> getAll(){
        Collection<Note> notes = new ArrayList<>();
        for (NotesRecord record : ((NotesDatabase)database).getNotesTable().getRecords()){
            notes.add(new Note(
                    record.getId(),
                    record.getTitle(),
                    record.getDetails()
            ));
        }
        return notes;
    }

    public Note getById(Integer id){
        for (NotesRecord record : ((NotesDatabase)database).getNotesTable().getRecords()){
            if (record.getId() == id){
                return new Note(
                    record.getId(),
                    record.getTitle(),
                    record.getDetails()
                );
            }
        }
        return null;
    }   
    
    public Note getByTitle(String title){
        for (NotesRecord record : ((NotesDatabase)database).getNotesTable().getRecords()){
            if (record.getTitle().equals(title)){
                return new Note(
                    record.getId(),
                    record.getTitle(),
                    record.getDetails()
                );
            }
        }
        return null;
    }


    public DatabaseContext(Database database) {
        super(database);
    }

    @Override
    protected void onModelCreating(ModelBuilder builder) {
        builder.applyConfiguration(new NoteConfiguration());
    }
}
