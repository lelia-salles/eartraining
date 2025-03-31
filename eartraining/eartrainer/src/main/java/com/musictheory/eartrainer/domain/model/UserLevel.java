package com.musictheory.eartrainer.domain.model;


import jakarta.persistence.*;

@Entity
@Table(name = "user_levels")
public class UserLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "level_id", nullable = false)
    private Level selectedLevel;

    public UserLevel() {}

    public UserLevel(User user, Level selectedLevel) {
        this.user = user;
        this.selectedLevel = selectedLevel;
    }

    public void saveLevel(User user, Level level) {
        this.user = user;
        this.selectedLevel = level;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Level getSelectedLevel() {
        return selectedLevel;
    }

    public void setSelectedLevel(Level selectedLevel) {
        this.selectedLevel = selectedLevel;
    }
}
