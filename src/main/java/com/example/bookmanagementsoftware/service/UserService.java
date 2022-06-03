package com.example.bookmanagementsoftware.service;


import com.example.bookmanagementsoftware.exceptions.InvalidIdException;
import com.example.bookmanagementsoftware.model.User;
import com.example.bookmanagementsoftware.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
    @RequiredArgsConstructor
    public class UserService {

        private final UserRepository userRepository;

        public List<User> getAllUser(){
            return userRepository.findAll();
        }
        public void addUser(User user) {
            userRepository.save(user);
        }
    public User getUser(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            return userRepository.findById(id).get();
        }else {
            throw new InvalidIdException("Invalid id");
        }
    }
    
    public void deleteUser(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            userRepository.delete(user.get());
        }
    }
}