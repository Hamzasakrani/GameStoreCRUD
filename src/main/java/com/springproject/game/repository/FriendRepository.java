package com.springproject.game.repository;

import java.util.Collection;

import com.springproject.game.model.Friend;
import com.springproject.game.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRepository extends JpaRepository<Friend, Long> {
    Collection<User> findByUserId(Long userId);
}
