# EarTrainer 🎵
O **EarTrainer** é uma API RESTful para treinar a percepção musical de intervalos e acordes com atividades interativas e níveis progressivos usando IA e Machine Learning para adaptar e garantir um aprendizado progressivo e personalizado.

`Desenvolvido para o projeto final do curso de GFT Desenvolvendo em Java com IA da DIO`

## Principais funcionalidades 🔆
---
- **Seleção de nível**: O usuário pode escolher entre níveis iniciante, intermediário e avançado para cada atividade.
- **Treinamento auditivo:** Atividades para reconhecer acordes e intervalos musicais por meio da audição.
- **Autenticação e perfil:** Login via email/senha ou Google OAuth, com um perfil personalizável.
- **Perfil do Usuário: O usuário pode adicionar e editar suas informações e suas redes sociais para compartilhar seu progresso.
- **Processamento e Geração de Áudio:** Sons gerados dinamicamente e as respostas do usuário são validadas automáticamente após 5 tentativas.
- **Arquitetura** escalável e **banco de dados** otimizado para testes e produção, e com comunicação em tempo real



## Principais Tecnologias Usadas 💾:
---

### Backend

- Java 21
- Spring Boot 3.x
- Spring Security & OAuth2
- Spring WebSockets
- Spring Data JPA (PostgreSQL ou H2)
- TarsosDSP (Processamento de áudio)
-J ava Sound API (Geração de som)
- TensorFlow Java (IA e Machine Learning)
- Gradle (Gerenciamento de dependências)

### Infraestrutura e otimização

- **Railway:** Inicialmente a configuração está feita para deploy no Railway, porém será configurado, posteriormente, o suporte para Docker e AWS.


### Frontend

- Thymeleaf (Templates para teste no backend)


### UX/UI 

- Figma (para posterior aprimoramento do Frontend)

[Acessar >>](https://www.figma.com/design/nWdoJYqm70ZisZ8qdeG17V/EarTrainer?node-id=0-1&t=5aYB5z8hnFgClNc2-1)

### UML

```mermaid
classDiagram
    direction TB
    
    class User {
        +Long id
        +String name
        +String email
        +String password
        +setName(String name)
        +setEmail(String email)
    }
    
    class UserRegisterDTO {
        +String name
        +String email
        +String password
    }

    class UserActivity {
        +Long id
        +User user
        +String selectedActivity
    }
    
    class UserLevel {
        +Long id
        +User user
        +String selectedLevel
    }
    
    class UserRepository {
        +Optional<User> findByEmail(String email)
    }

    class ActivitySelectorRepository {
        +save(UserActivity activity)
    }

    class LevelSelectorRepository {
        +save(UserLevel level)
    }

    class UserRegisterService {
        +User registerUser(UserRegisterDTO userDTO)
    }
    
    class UserService {
        +Optional<User> getUserByEmail(String email)
        +User updateUserProfile(Long userId, String newName, String newEmail)
    }

    class MLTrainerService {
        +String getExerciseForLevel(String level, String type)
    }

    class AudioService {
        +byte[] generateSound(String note)
        +void playSound(byte[] audioData)
    }

    class TrainerService {
        +String getExercise(Long userId, String level, String type)
        +String validateAnswer(Long userId, String level, String answer, String type)
    }

    class ActivitySelectorService {
        +UserActivity saveUserActivity(User user, String activity)
    }

    class LevelSelectorService {
        +UserLevel saveUserLevel(User user, String level)
    }

    class TrainerController {
        +ResponseEntity<String> getExercise(Long userId, String level, String type)
        +ResponseEntity<String> validateAnswer(Long userId, String level, String answer, String type)
    }

    UserRegisterDTO --> UserRegisterService
    UserRegisterService --> UserRepository
    User --> UserActivity
    User --> UserLevel
    UserActivity --> ActivitySelectorRepository
    UserLevel --> LevelSelectorRepository
    ActivitySelectorService --> ActivitySelectorRepository
    LevelSelectorService --> LevelSelectorRepository
    MLTrainerService --> TrainerService
    AudioService --> TrainerService
    TrainerService --> TrainerController
    TrainerController --> User
```
