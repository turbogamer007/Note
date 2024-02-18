package com.example.Note.Service;

import com.example.Note.Entity.User;
import com.example.Note.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("userRepository")
    UserRepository userRepository;

    @Override
    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }
}
