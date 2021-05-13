package com.springproject.game.controller;

import java.util.Collection;

import com.springproject.game.model.User;
import com.springproject.game.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository repository;

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody User user) {

        return new ResponseEntity<>(repository.save(user), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Collection<User>> getAllUsers() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserWithId(@PathVariable Long id) {
        return new ResponseEntity<User>(repository.findById(id).get(), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public void deleteUserWithId(@PathVariable Long id) {
        repository.deleteById(id);
    }


}
