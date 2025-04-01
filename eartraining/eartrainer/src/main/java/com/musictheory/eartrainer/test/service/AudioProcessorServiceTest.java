package com.musictheory.eartrainer.test.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AudioProcessorServiceTest {

    private final AudioProcessorService audioProcessorService = new AudioProcessorService();

    @Test
    void testGenerateSound() {
        String note = "C4";
        String generatedSound = audioProcessorService.generateSound(note);

        assertEquals("Generated Sound for C4", generatedSound);
    }
}
