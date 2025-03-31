package com.musictheory.eartrainer.domain.dto;

import java.util.List;

public class LevelDTO {
    private String difficulty;
    private List<QuestionDTO> questions;

    public LevelDTO() {}

    public LevelDTO(String difficulty, List<QuestionDTO> questions) {
        this.difficulty = difficulty;
        this.questions = questions;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }
}
