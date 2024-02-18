package com.example.Note.repository;

import com.example.Note.Entity.Note;
import org.springframework.stereotype.Repository;

public interface NoteRepository {


    Note getNoteById(int id);//get

    int insert (Note note);//post

    int delete (int id);//delete

    int update (Note note);//update

}
