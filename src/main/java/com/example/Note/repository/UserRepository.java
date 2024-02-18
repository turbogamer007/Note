package com.example.Note.repository;

import com.example.Note.Entity.User;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends CrudRepository<User, String> {
    @Transactional
    @Modifying
    @Query("INSERT INTO user (username, password, roles) VALUES (:username, :password, :roles)")
    int insertUser(String username,String password,String roles);
    User getUserByUsername(String username);

//    User save(String username);
//
//    User updateUser(String username);
//
//    User deleteUser(String username);


}
