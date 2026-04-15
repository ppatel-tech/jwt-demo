package com.example.jwtdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.jwtdemo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

