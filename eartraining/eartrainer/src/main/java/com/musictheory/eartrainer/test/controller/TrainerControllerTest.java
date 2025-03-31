package com.musictheory.eartrainer.test.controller;

import com.musictheory.eartrainer.application.service.TrainerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TrainerControllerTest {

    @Mock
    private TrainerService trainerService;

    @InjectMocks
    private TrainerController trainerController;

    @Test
    void testGetExercise() {
        String mockExercise = "Intervalo: Terça Maior";
        when(trainerService.getExercise(1L, "Beginner", "Interval")).thenReturn(mockExercise);

        ResponseEntity<String> response = trainerController.getExercise(1L, "Beginner", "Interval");
        
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(mockExercise, response.getBody());
    }
}
