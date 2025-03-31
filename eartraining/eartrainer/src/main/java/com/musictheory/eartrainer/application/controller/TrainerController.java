package com.musictheory.eartrainer.application.controller;

import com.musictheory.eartrainer.application.service.TrainerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trainer")
public class TrainerController {

    private final TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping("/exercise")
    public ResponseEntity<String> getExercise(@RequestParam Long userId, @RequestParam String level, @RequestParam String type) {
        String exercise = trainerService.getExercise(userId, level, type);
        return ResponseEntity.ok(exercise);
    }

    @PostMapping("/validate")
    public ResponseEntity<Boolean> validateAnswer(
            @RequestParam Long userId,
            @RequestParam String level,
            @RequestParam String answer,
            @RequestParam String type) {

        boolean isCorrect = trainerService.validateAnswer(userId, level, answer, type);
        return ResponseEntity.ok(isCorrect);
    }
}
