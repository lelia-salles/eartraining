package com.musictheory.eartrainer.application.service;

import org.springframework.stereotype.Service;

@Service
public class AudioProcessorService {

    public byte[] generateSound(String note) {
        // Lógica para gerar áudio de uma nota específica
        return new byte[0]; // Implementação real pode usar bibliotecas como TarsosDSP
    }

    public void processAudio(byte[] audioData) {
        // Lógica para processar áudio recebido do usuário
    }
}
