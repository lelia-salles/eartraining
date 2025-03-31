package com.musictheory.eartrainer.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_registers")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegister {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String registrationDate;

    @Column(nullable = false, length = 20)
    private String status;  

    public UserRegister(User user, String registrationDate, String status) {
        this.user = user;
        this.registrationDate = registrationDate;
        this.status = status;
    }
}

