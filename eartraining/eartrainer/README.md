# EarTrainer
O **EarTrainer** é uma API RESTful em Java 21, usando Spring, Gradle e Railway, para treinar a percepção musical de intervalos e acordes com atividades interativas e níveis progressivos.
Ele oferece atividades interativas onde os usuários podem ouvir sons e identificar notas, intervalos ou acordes corretamente. O objetivo é aprimorar o ouvido musical de forma progressiva, com diferentes níveis de dificuldade.

Desenvolvido para o projeto final do curso de GFT Desenvolvendo em Java com IA da DIO

## Principais funcionalidades:
- **Seleção de nível**: O usuário pode escolher entre níveis iniciante, intermediário e avançado para cada atividade.
- **Treinamento auditivo:** Atividades para reconhecer acordes e intervalos musicais por meio da audição.
- **Validação de respostas:** O usuário recebe feedback se sua resposta está correta ou errada.
- Autenticação e perfil:** Login via email/senha ou Google OAuth, com um perfil personalizável.
Redes sociais: O usuário pode adicionar e editar suas redes sociais dentro do perfil.

## UX/UI (Figma)

[Acessar >>](https://www.figma.com/design/nWdoJYqm70ZisZ8qdeG17V/EarTrainer?node-id=0-1&t=5aYB5z8hnFgClNc2-1)

## UML

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
        - String type // e.g., Chords, Intervals
        - List<Level> levels
        + start()
    }

    class Level {
        - String difficulty // Beginner, Intermediate, Advanced
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
