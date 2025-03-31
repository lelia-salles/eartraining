package com.musictheory.eartrainer.application.service;

import org.springframework.stereotype.Service;

@Service
public class TrainerService {

    public String getExercise(Long userId, String level, String type) {
        // Lógica para buscar um exercício para o usuário
        return "Exercise for user " + userId + " at level " + level;
    }

    public boolean validateAnswer(Long userId, String level, String answer, String type) {
        // Verifica se a resposta do usuário está correta
        return true; // Simulação de validação
    }
}
