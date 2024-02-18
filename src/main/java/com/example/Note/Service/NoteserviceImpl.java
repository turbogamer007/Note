package com.example.Note.Service;

import com.example.Note.Entity.Note;
import com.example.Note.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class NoteserviceImpl implements NoteService{



    @Autowired
    NoteRepository noteRepository;

    @Override
    public Note getNoteById(int id) {
        return noteRepository.getNoteById(id);
    }

    @Override
    public int insert(Note note) {
        return noteRepository.insert(note);
    }

    @Override
    public int delete(int id) {
        return noteRepository.delete(id);
    }

    @Override
    public int update(Note note) {
        return noteRepository.update(note);
    }
}
