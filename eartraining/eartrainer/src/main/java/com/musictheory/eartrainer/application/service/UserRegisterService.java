package com.musictheory.eartrainer.service;

public class UserRegisterService {

  

import com.musicista.eartrainer.dto.UserRegisterDTO;
import com.musicista.eartrainer.model.User;
import com.musicista.eartrainer.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterService {
    
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserRegisterService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public User registerUser(UserRegisterDTO userDTO) {
        if (userRepository.findByEmail(userDTO.getEmail()).isPresent()) {
            throw new IllegalArgumentException("E-mail já cadastrado.");
        }

        // Criptografar senha antes de salvar
        String encryptedPassword = passwordEncoder.encode(userDTO.getPassword());

        User user = new User(userDTO.getName(), userDTO.getEmail(), encryptedPassword);
        return userRepository.save(user);
    }
}

}