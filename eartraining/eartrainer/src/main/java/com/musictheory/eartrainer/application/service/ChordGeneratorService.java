package com.musictheory.eartrainer.application.service;

import org.springframework.stereotype.Service;

@Service
public class ChordGeneratorService {

    public String generateChordForLevel(String level) {
        // Lógica para gerar um acorde com base no nível do usuário
        return "Cmaj7"; // Exemplo
    }
}
