package com.musictheory.eartrainer.domain.dto;

public class QuestionDTO {
    private String soundClip;
    private String correctAnswer;

    public QuestionDTO() {}

    public QuestionDTO(String soundClip, String correctAnswer) {
        this.soundClip = soundClip;
        this.correctAnswer = correctAnswer;
    }

    public String getSoundClip() {
        return soundClip;
    }

    public void setSoundClip(String soundClip) {
        this.soundClip = soundClip;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
