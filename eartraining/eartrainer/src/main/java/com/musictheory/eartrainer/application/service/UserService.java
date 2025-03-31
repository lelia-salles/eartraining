package com.musictheory.eartrainer.application.service;


import com.musictheory.eartrainer.dto.UserDTO;
import com.musictheory.eartrainer.dto.UserRegisterDTO;
import com.musictheory.eartrainer.model.User;
import com.musictheory.eartrainer.repository.UserRepository;
import com.musictheory.eartrainer.util.PasswordEncoderUtil;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(UserRegisterDTO userDTO) {
        Optional<User> existingUser = userRepository.findByEmail(userDTO.getEmail());
        
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("This email already exists");
        }

        String encryptedPassword = PasswordEncoderUtil.encode(userDTO.getPassword());
        User user = new User(userDTO.getName(), userDTO.getEmail(), encryptedPassword);
        
        return userRepository.save(user);
    }

    public UserDTO getUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        
        return user.map(u -> new UserDTO(u.getName(), u.getEmail()))
                   .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }
}
