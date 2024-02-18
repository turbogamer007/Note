package com.example.Note.Entity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Note {

    @Id // to tell the primary key
    private int id;
    private String content;
    private String userUsername;
}

// public record Note(int id, String content){} //
