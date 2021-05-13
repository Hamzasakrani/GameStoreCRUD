package com.springproject.game.repository;

import java.util.Collection;

import com.springproject.game.model.User;
import com.springproject.game.model.UserGame;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserGameRepository extends JpaRepository<UserGame, Long>{
    Collection<User> findByUserId(Long userId);
}
