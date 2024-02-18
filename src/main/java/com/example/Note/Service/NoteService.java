package com.example.Note.Service;
// method that can be created in interface: default, private , static


import com.example.Note.Entity.Note;
import org.springframework.stereotype.Service;

public interface NoteService {
    Note getNoteById(int id);//get

    int insert (Note note);//post

    int delete (int id);//delete

    int update (Note note);//update

}
