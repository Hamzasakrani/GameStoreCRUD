package com.springproject.game.controller;

import java.util.Collection;

import com.springproject.game.model.Game;
import com.springproject.game.repository.GameRepository;

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
@RequestMapping("/api/store/game")
public class GameController {
    @Autowired
    private GameRepository repository;

    @PostMapping
    public ResponseEntity<?> addGame(@RequestBody Game game) {
        System.out.println(game.toString());
        return new ResponseEntity<>(repository.save(game), HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<Collection<Game>> getAllGames() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> getGameWithId(@PathVariable Long id) {
        return new ResponseEntity<Game>(repository.findById(id).get(), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public void deleteGameWithId(@PathVariable Long id) {
        repository.deleteById(id);
    }   
}
