package com.musictheory.eartrainer.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_activities")
public class UserActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String selectedActivity;

    public UserActivity() {}

    public UserActivity(User user, String selectedActivity) {
        this.user = user;
        this.selectedActivity = selectedActivity;
    }

    public void saveActivity(User user, String activity) {
        this.user = user;
        this.selectedActivity = activity;
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

    public String getSelectedActivity() {
        return selectedActivity;
    }

    public void setSelectedActivity(String selectedActivity) {
        this.selectedActivity = selectedActivity;
    }
}
