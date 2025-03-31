package com.musictheory.eartrainer.domain.model;


import jakarta.persistence.*;

@Entity
@Table(name = "ear_trainers")
public class EarTrainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "activity_id", nullable = false)
    private Activity activity;

    @ManyToOne
    @JoinColumn(name = "level_id", nullable = false)
    private Level level;

    public EarTrainer() {}

    public EarTrainer(User user, Activity activity, Level level) {
        this.user = user;
        this.activity = activity;
        this.level = level;
    }

    public void selectLevel(Level level) {
        this.level = level;
    }

    public void selectActivity(Activity activity) {
        this.activity = activity;
    }

    public void startSession() {
        System.out.println("Starting session for activity: " + activity.getType() + " at level: " + level.getDifficulty());
        activity.start(); // Inicia a atividade
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

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
