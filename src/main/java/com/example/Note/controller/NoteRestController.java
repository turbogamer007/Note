package com.example.Note.controller;

import com.example.Note.Entity.Note;
import com.example.Note.Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/note/")
public class NoteRestController {

//    @GetMapping(value = "/test")
//    public String test(){
//        return "index";
//    }

    @Autowired
    NoteService noteService;

    @GetMapping(value = "{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable int id){
        Note note = noteService.getNoteById(id);
        return note!=null ? ResponseEntity.ok().body(note):ResponseEntity.notFound().build();
    }
    @PostMapping(value = "addNote")
    public ResponseEntity<String> insert(@RequestBody Note note){
        int result = noteService.insert(note);
        return result>0 ? ResponseEntity.ok().body(String.valueOf(note)):ResponseEntity.notFound().build();
    }

    @PutMapping(value = "put/{id}")
    public ResponseEntity<Note> update(@RequestBody Note note){
        int result = noteService.update(note);
        return result>0? ResponseEntity.ok().body(note):ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<Note> delete(@PathVariable int id){
       int result = noteService.delete(id);
        return result>0? ResponseEntity.ok().build():ResponseEntity.noContent().build();
    }



}

