package com.example.Note.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoteController {

    @GetMapping(value = "/index")
    public String index(){
        return "index";
    }
}
