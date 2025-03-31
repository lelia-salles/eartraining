package com.musictheory.eartrainer.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoderUtil {
    private static final BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();

    public static String encode(String password) {
        return ENCODER.encode(password);
    }
}
O que foi corrigido?
✔ Removidos métodos duplicados.
✔ PasswordEncoderUtil movido para um arquivo separado.
✔ Uso correto do Lombok (@Getter, @Setter, @ToString, etc.).
✔ @ToString(exclude = "password") já oculta a senha corretamente.
✔ Código mais limpo e modular.

Agora o código está correto! 🚀







Você disse:
e agora o código do User está corrigido? responda comsim ou não? package com.musictheory.eartrainer.domain.model;

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
public class User {
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


O ChatGPT disse:
Sim. ✅






Você disse:
certo, agora crie uma descrição para documentação no código 
em relação ao arquivo user que acabamos de criar, em ingles



2/2

O ChatGPT disse:
Here is the documentation for the User class:

java
Copiar
Editar
package com.musictheory.eartrainer.domain.model;

import jakarta.persistence.*;
import lombok.*;
import com.musictheory.eartrainer.util.PasswordEncoderUtil;

/**
 * Represents a user in the system.
 * <p>
 * This entity is mapped to the "users" table in the database and stores user-related information, 
 * including name, email, and password. The password is securely hashed before being stored.
 * </p>
 * 
 * <p>
 * This class utilizes Lombok annotations for boilerplate code reduction and follows JPA conventions 
 * for persistence.
 * </p>
 * 
 * <h2>Attributes:</h2>
 * <ul>
 *   <li><b>id</b>: Unique identifier for the user (auto-generated).</li>
 *   <li><b>name</b>: Full name of the user.</li>
 *   <li><b>email</b>: Unique email address used for authentication.</li>
 *   <li><b>password</b>: Hashed password for secure authentication.</li>
 * </ul>
 * 
 * <h2>Behavior:</h2>
 * <ul>
 *   <li><b>setPassword(String password)</b>: Hashes the password before setting it.</li>
 *   <li><b>getMaskedPassword()</b>: Returns a masked password string to prevent direct exposure.</li>
 * </ul>
 * 
 * <h2>Usage Example:</h2>
 * <pre>
 *     User user = new User("John Doe", "john.doe@example.com", "securePassword");
 *     System.out.println(user.getMaskedPassword()); // Output: ********
 * </pre>
 * 
 * @author [Your Name]
 * @version 1.0
 */
@Entity
@Table(name = "users")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id", "email"})
@ToString(exclude = "password")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false)
    private String password;

    /**
     * Creates a new user instance with the given name, email, and password.
     * The password is hashed before being stored.
     *
     * @param name User's full name.
     * @param email User's unique email address.
     * @param password User's plain-text password (will be hashed).
     */
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.setPassword(password);
    }

    /**
     * Sets and hashes the user's password before storing it.
     *
     * @param password The plain-text password to be hashed and stored.
     */
    public void setPassword(String password) {
        this.password = PasswordEncoderUtil.encode(password);
    }

    /**
     * Returns a masked password representation to prevent exposure.
     *
     * @return Masked password as a string (e.g., "********").
     */
    public String getMaskedPassword() {
        return "********";
    }
}
This documentation ensures clarity on the purpose, behavior, and usage of the User entity. 🚀






Você disse:
acho que falta criarmos a pasta util para a estrutra não é mesmo?


O ChatGPT disse:
Sim, exatamente! Para manter a estrutura do projeto organizada, você deve criar um pacote util e mover a classe PasswordEncoderUtil para ele.

A estrutura ficaria assim:

pgsql
Copiar
Editar
com/musictheory/eartrainer/
│── domain/
│   ├── model/
│   │   ├── User.java
│── util/
│   ├── PasswordEncoderUtil.java
Agora, crie o arquivo PasswordEncoderUtil.java dentro do pacote util:

java
Copiar
Editar
package com.musictheory.eartrainer.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Utility class for password encryption using BCrypt.
 * <p>
 * This class provides a static method to hash passwords securely.
 * </p>
 *
 * <h2>Usage Example:</h2>
 * <pre>
 *     String hashedPassword = PasswordEncoderUtil.encode("mySecurePassword");
 * </pre>
 *
 * @author [Your Name]
 * @version 1.0
 */
@Component
public class PasswordEncoderUtil {
    private static final BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();

    
     @param password The plain-text password to be hashed.
     @return The hashed password.
     
    public static String encode(String password) {
        return ENCODER.encode(password);
    }
}








