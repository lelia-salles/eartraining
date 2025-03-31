package com.musictheory.eartrainer.application.service;

import org.springframework.stereotype.Service;

@Service
public class MLTrainerService {

    public String getExerciseForLevel(String level, String type) {
        // IA pode sugerir exercícios personalizados
        return "Generated exercise for " + level + " - " + type;
    }
}
