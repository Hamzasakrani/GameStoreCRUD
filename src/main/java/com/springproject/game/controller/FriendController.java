package com.springproject.game.controller;

import java.util.Collection;

import com.springproject.game.model.Friend;
import com.springproject.game.model.User;
import com.springproject.game.repository.FriendRepository;
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
public class FriendController {
    @Autowired
    private UserRepository userrepository;
    @Autowired
    private FriendRepository friendrepository;

    @GetMapping("/{userId}/friends")
    public ResponseEntity<Collection<User>> getFriendByUserId(@PathVariable Long userId) throws NotFoundException {
        if (!userrepository.existsById(userId)) {
            throw new NotFoundException("User not found!");
        }
        return new ResponseEntity<>(friendrepository.findByUserId(userId), HttpStatus.OK);
    }

    @PostMapping("/{userId}/friends")
    public ResponseEntity<?> addUser(@PathVariable Long userId, @RequestBody Friend friend) throws NotFoundException {
       
        return new ResponseEntity<>(userrepository.findById(userId).map(user -> {
            friend.setfriend(user);
            return friendrepository.save(friend);
        }).orElseThrow(() -> new NotFoundException("User not found!")), HttpStatus.CREATED);

    }

    @DeleteMapping("/{userId}/friends/{friendId}")
    public void deleteGameWithId(@PathVariable Long userId, @PathVariable Long friendId) throws NotFoundException {
        if (!userrepository.existsById(userId)) {
            throw new NotFoundException("User not found!");
        }
        friendrepository.findById(friendId).map(assignment -> {
            friendrepository.deleteById(friendId);
            return "Deleted Successfully!";
        }).orElseThrow(() -> new NotFoundException("friend not found!"));

    }

}
