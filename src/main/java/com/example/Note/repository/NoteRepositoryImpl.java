package com.example.Note.repository;

import com.example.Note.Entity.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class NoteRepositoryImpl implements NoteRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Note getNoteById(int id) {
        return jdbcTemplate.queryForObject("Select * from note where id = ?",new Object[]{id},new BeanPropertyRowMapper<>(Note.class));
    }

    @Override
    public int insert(Note note) {
        return jdbcTemplate.update("insert into note (content, user_username) values (?, ?)",note.getContent(),note.getUserUsername());
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("delete from note where id = ?",id);
    }

    @Override
    public int update(Note note) {
        return jdbcTemplate.update("update note set content=? where id=?",note.getContent(),note.getId());
    }
}
