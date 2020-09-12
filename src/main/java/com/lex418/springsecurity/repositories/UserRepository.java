package com.lex418.springsecurity.repositories;

import com.lex418.springsecurity.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface  UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByUsername(String username);
}
