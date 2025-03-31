package com.musictheory.eartrainer.domain.model;

import jakarta.persistence.*;
import lombok.*;
import com.musictheory.eartrainer.util.PasswordEncoderUtil;

@Entity
@Table(name = "users")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id", "email"})
@ToString(exclude = "password")
public class UserRegister {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false)
    private String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.setPassword(password);
    }

    public void setPassword(String password) {
        this.password = PasswordEncoderUtil.encode(password);
    }

    public String getMaskedPassword() {
        return "********";
    }
}
