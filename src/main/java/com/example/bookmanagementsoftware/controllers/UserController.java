package com.example.bookmanagementsoftware.controllers;

import com.example.bookmanagementsoftware.DTO.API;
import com.example.bookmanagementsoftware.model.User;
import com.example.bookmanagementsoftware.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUser(id));

    }
    
    @PostMapping
    public ResponseEntity<API> addUser(@RequestBody @Valid User user){
        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(new API("New user was added!", 201));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<API> deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(new API("User was deleted!", 201));

    }
}
