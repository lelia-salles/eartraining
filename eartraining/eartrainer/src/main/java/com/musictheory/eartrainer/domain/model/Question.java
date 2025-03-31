package com.musictheory.eartrainer.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String soundClip;

    @Column(nullable = false)
    private String correctAnswer;

    public Question() {}

    public Question(String soundClip, String correctAnswer) {
        this.soundClip = soundClip;
        this.correctAnswer = correctAnswer;
    }

    public String validateAnswer(String userAnswer) {
        return userAnswer.equalsIgnoreCase(correctAnswer) ? "Correct" : "Incorrect";
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
