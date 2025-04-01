package com.musictheory.eartrainer.test.repository;

import com.musictheory.eartrainer.application.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testFindByEmail() {
        User user = new User("Alice", "alice@example.com", "hashed_password");
        userRepository.save(user);

        Optional<User> foundUser = userRepository.findByEmail("alice@example.com");

        assertTrue(foundUser.isPresent());
        assertEquals("Alice", foundUser.get().getName());
    }
}
