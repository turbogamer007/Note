package com.example.Note.controller;

import com.example.Note.Entity.User;
import com.example.Note.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/user/")
public class UserController {
    @Autowired
    UserRepository userRepository;

//    @Autowired
//    UserService userService;

    @PostMapping(value = "postMapping/adduser")
    public ResponseEntity<User> save(@RequestBody User user) {

        int result = userRepository.insertUser(user.getUsername(),user.getPassword(),user.getRoles());
        // Builder design pattern
        return result>0? ResponseEntity.ok().body(user):ResponseEntity.noContent().build();
    }
    //Genric ype ... khud se body de sakte h

    @GetMapping(value = "getMapping/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username){

        Optional<User> user = userRepository.findById(username);
        return !user.isEmpty() ? ResponseEntity.ok().body(user.get()):ResponseEntity.notFound().build();
    }

    // put mapping is used to update the database
    @PutMapping(value = "putMapping/{username}")
    public ResponseEntity<User> updateUser(@RequestBody User user){

        User result = userRepository.save(user);
        return result!=null? ResponseEntity.ok().body(result):ResponseEntity.noContent().build();
    }

    // delete mapping use to delete the data from the database
    @DeleteMapping(value = "deleteMapping/{username}")
    public ResponseEntity<Void> deleteUser(@PathVariable String username){
        userRepository.deleteById(username);
        return ResponseEntity.ok().build();
    }

    //Post   : Insert the values in DB
    //Get    : get the data of the user
    //Put    : Update or insert the data in the DB
    //Delete : Delete the data from the DB

    //monolithic : all logics contains  in application server
    // microservices : dividing the project in parts like user,note so on
    //pros: independent, reliability, code re-use,communication: 1.HTTP(through rest template), 2.messaging(Async)
    //cons: server cos , maintenance high

}
