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



## Principais Tecnologias Usadas :FLOPPY_DISK:
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

``` mermaidclassDiagram
    class EarTrainer {
        - User user
        - Activity activity
        - Level level
        + selectLevel(Level level)
        + selectActivity(Activity activity)
        + startSession()
    }

    class User {
        - String name
        - String email
        - String profileImage
        - List<SocialLink> socialLinks
        + editProfile(String name, String email, String profileImage)
        + addSocialLink(SocialLink link)
    }

    class SocialLink {
        - String platform
        - String url
    }

    class Activity {
        - String type 
        - List<Level> levels
        + start()
    }

    class Level {
        - String difficulty 
        - List<Question> questions
        + loadQuestions()
    }

    class Question {
        - String soundClip
        - String correctAnswer
        + validateAnswer(String userAnswer)
    }

    class Authentication {
        + login(String email, String password)
        + loginWithGoogle()
    }

    class Subscription {
        - boolean isSubscribed
        + subscribe()
        + unsubscribe()
    }

    class AudioProcessor {
        + generateSound(String note)
        + processAudio(byte[] audioData)
    }

    class MachineLearning {
        + analyzePattern(byte[] audioData)
    }

    class UserActivity {
        - User user
        - String selectedActivity
        + saveActivity(User user, String activity)
    }

    class UserLevel {
        - User user
        - String selectedLevel
        + saveLevel(User user, String level)
    }

    class ActivitySelectorController {
        + selectActivity(String activity)
    }

    class LevelSelectorController {
        + selectLevel(String level)
    }

    class TrainerController {
        + getExercise(Long userId, String level, String type)
        + validateAnswer(Long userId, String level, String answer, String type)
    }

    class MLTrainerService {
        + getExerciseForLevel(String level, String type)
    }

    class TrainerService {
        + getExercise(Long userId, String level, String type)
        + validateAnswer(Long userId, String level, String answer, String type)
    }

    class IntervalGeneratorService {
        + generateIntervalForLevel(String level)
    }

    class ChordGeneratorService {
        + generateChordForLevel(String level)
    }

    EarTrainer --> User
    EarTrainer --> Activity
    EarTrainer --> Level
    User --> SocialLink
    Activity --> Level
    Level --> Question
    EarTrainer --> AudioProcessor
    EarTrainer --> MachineLearning
    AudioProcessor --> "TarsosDSP & JavaSoundAPI"
    MachineLearning --> "TensorFlow Java"
    User --> UserActivity
    UserActivity --> ActivitySelectorController
    User --> UserLevel
    UserLevel --> LevelSelectorController
    ActivitySelectorController --> TrainerController
    LevelSelectorController --> TrainerController
    TrainerController --> TrainerService
    TrainerService --> MLTrainerService
    TrainerService --> IntervalGeneratorService
    TrainerService --> ChordGeneratorService
```
