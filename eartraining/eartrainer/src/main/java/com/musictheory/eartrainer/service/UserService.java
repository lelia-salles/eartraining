package com.musictheory.eartrainer.service;


import com.musictheory.eartrainer.dto.UserDTO;
import com.musictheory.eartrainer.model.User;
import com.musictheory.eartrainer.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return new UserDTO(user.getName(), user.getEmail());
    }
}

