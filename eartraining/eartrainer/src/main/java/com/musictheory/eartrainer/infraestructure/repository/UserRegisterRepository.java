package com.musictheory.infraestructure.eartrainer.repository;

import com.musictheory.eartrainer.model.UserRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegisterRepository extends JpaRepository<UserRegister, Long> {
}

