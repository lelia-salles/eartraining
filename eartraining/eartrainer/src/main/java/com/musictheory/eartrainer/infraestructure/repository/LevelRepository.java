package com.musictheory.eartrainer.infraestructure.repository;

import com.musictheory.eartrainer.model.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelRepository extends JpaRepository<Level, Long> {
}
