package com.musictheory.eartrainer.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRegisterDTO {

    @NotBlank(message = "name field is mandatory")
    @Size(min = 2, max = 50, message = "Name length must be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "email field is mandatory")
    @Size(message = "Please, enter a valid email")
    private String email;

    @NotBlank(message = "password field is mandatory")
    @Size(min = 8, message = "Password must have a minimum of 8 characters")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
