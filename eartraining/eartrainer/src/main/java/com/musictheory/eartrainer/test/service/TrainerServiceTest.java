package com.musictheory.eartrainer.test.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TrainerServiceTest {

    @Mock
    private MLTrainerService mlTrainerService;

    @InjectMocks
    private TrainerService trainerService;

    @Test
    void testGetExercise() {
        String expectedExercise = "Intervalo: Quinta Perfeita";
        when(mlTrainerService.getExerciseForLevel("Intermediate", "Interval")).thenReturn(expectedExercise);

        String exercise = trainerService.getExercise(1L, "Intermediate", "Interval");

        assertEquals(expectedExercise, exercise);
    }
}
