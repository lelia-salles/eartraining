package com.musictheory.eartrainer.service;


import com.musictheory.eartrainer.dto.UserDTO;
import com.musictheory.eartrainer.dto.UserRegisterDTO;
import com.musictheory.eartrainer.model.User;
import com.musictheory.eartrainer.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }
    
    public User registerUser(UserRegisterDTO userDTO){
        if (userRepository.findByEmail((userDTO.getEmail()).isPresent()){
            throw new IllegalArgumentException("This email already exists");
        }
// criptografia
        
        String encryptedPassword = passwordEncoder.encode(userDTO.getPassword());
            User user = new User();
                return userRepository.save(user);
        
        }
    public UserDTO getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return new UserDTO(user.getName(), user.getEmail());    
    }
}
