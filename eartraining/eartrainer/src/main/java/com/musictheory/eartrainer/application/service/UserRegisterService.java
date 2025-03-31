package com.musictheory.eartrainer.application.service;

import com.musictheory.eartrainer.domain.model.User;
import com.musictheory.eartrainer.domain.model.UserRegister;
import com.musictheory.eartrainer.dto.UserRegisterDTO;
import com.musictheory.eartrainer.repository.UserRepository;
import com.musictheory.eartrainer.repository.UserRegisterRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class UserRegisterService {

    private final UserRepository userRepository;
    private final UserRegisterRepository userRegisterRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserRegisterService(UserRepository userRepository, UserRegisterRepository userRegisterRepository) {
        this.userRepository = userRepository;
        this.userRegisterRepository = userRegisterRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public UserRegister registerUser(UserRegisterDTO userDTO) {
        if (userRepository.findByEmail(userDTO.getEmail()).isPresent()) {
            throw new IllegalArgumentException("E-mail já cadastrado.");
        }

        // Criando usuário com senha criptografada
        String encryptedPassword = passwordEncoder.encode(userDTO.getPassword());
        User user = new User(userDTO.getName(), userDTO.getEmail(), encryptedPassword);
        userRepository.save(user);

        // Criando registro de usuário
        String registrationDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        UserRegister userRegister = new UserRegister(user, registrationDate, "PENDENTE");

        return userRegisterRepository.save(userRegister);
    }
}

