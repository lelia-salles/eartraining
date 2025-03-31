package com.musictheory.eartrainer.repository;

public interface UserRegisterRepository e

    xtends JpaRepository

    <UserRegister, Long>
               Optional<UserRegister>
        findByEmail(String email);

            

