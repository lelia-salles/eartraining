package com.musictheory.eartrainer.domain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "levels")
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String difficulty;

    @OneToMany(mappedBy = "level", cascade = CascadeType.ALL)
    private List<Question> questions;

    public Level() {}

    public Level(String difficulty, List<Question> questions) {
        this.difficulty = difficulty;
        this.questions = questions;
    }

    public void loadQuestions() {
        
        System.out.println("Loading questions for level: " + difficulty);
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
