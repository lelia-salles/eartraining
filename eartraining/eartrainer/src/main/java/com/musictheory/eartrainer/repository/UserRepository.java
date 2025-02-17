package com.musictheory.eartrainer.repository;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import com.musictheory.eartrainer.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findById(String Id);

    User findByEmail(String email);
}
