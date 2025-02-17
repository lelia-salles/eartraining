package com.musictheory.eartrainer.controller;

import com.musictheory.eartrainer.service.UserRegisterService;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class UserRegisterController {

    @RestController
    @RequestMapping("/register")
    private final UserRegisterController userRegisterController;

    public UserRegisterController(UserRegisterService userRegisterService){
        this.userRegisterService = userRegisterService;
    }
}
