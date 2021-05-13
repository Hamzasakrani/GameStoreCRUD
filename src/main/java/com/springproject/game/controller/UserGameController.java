package com.springproject.game.controller;

import java.util.Collection;

import com.springproject.game.model.User;
import com.springproject.game.model.UserGame;
import com.springproject.game.repository.UserGameRepository;
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

import javassist.NotFoundException;

@RestController
@RequestMapping("/api/users")
public class UserGameController {
     @Autowired
    private UserRepository userrepository;
    @Autowired
    private UserGameRepository usergamerepository;

    @GetMapping("/{userId}/games")
    public ResponseEntity<Collection<User>> getFriendByUserId(@PathVariable Long userId) throws NotFoundException {
        if (!userrepository.existsById(userId)) {
            throw new NotFoundException("User not found!");
        }
        return new ResponseEntity<>(usergamerepository.findByUserId(userId), HttpStatus.OK);
    }

    @PostMapping("/{userId}/games")
    public ResponseEntity<?> addUser(@PathVariable Long userId, @RequestBody UserGame usergame) throws NotFoundException {

        return new ResponseEntity<>(userrepository.findById(userId).map(user -> {
            usergame.setGame(user);
            return usergamerepository.save(usergame);
        }).orElseThrow(() -> new NotFoundException("User not found!")), HttpStatus.CREATED);

    }

    @DeleteMapping("/{userId}/games/{gameId}")
    public void deleteGameWithId(@PathVariable Long userId, @PathVariable Long usergame) throws NotFoundException {
        if (!userrepository.existsById(userId)) {
            throw new NotFoundException("User not found!");
        }
        usergamerepository.findById(userId).map(assignment -> {
            usergamerepository.deleteById(usergame);
            return "Deleted Successfully!";
        }).orElseThrow(() -> new NotFoundException("Game not found!"));

    }
}
