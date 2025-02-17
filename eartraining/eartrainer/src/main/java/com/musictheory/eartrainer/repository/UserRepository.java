package com.musictheory.eartrainer.repository;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import com.musictheory.eartrainer.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findById(String Id);

    Optional<User>
        findByEmail(String email);

   }
