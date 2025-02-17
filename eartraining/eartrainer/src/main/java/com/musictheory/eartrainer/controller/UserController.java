package com.musictheory.eartrainer.controller;

import com.musictheory.eartrainer.dto.UserDTO;
import com.musictheory.eartrainer.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/{email}")
    public UserDTO getUser(@PathVariable String email){
        return userService.getUserByEmail(email);
    }

}
