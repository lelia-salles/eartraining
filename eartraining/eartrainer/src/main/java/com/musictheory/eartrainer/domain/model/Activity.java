package com.musictheory.eartrainer.domain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "activities")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String type;

    @OneToMany(mappedBy = "activity", cascade = CascadeType.ALL)
    private List<Level> levels;

    public Activity() {}

    public Activity(String type, List<Level> levels) {
        this.type = type;
        this.levels = levels;
    }

    public void start() {
        // Iniciar a atividade (ex: gerar os exercícios, mostrar o conteúdo)
        System.out.println("Activity started: " + type);
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Level> getLevels() {
        return levels;
    }

    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }
}
