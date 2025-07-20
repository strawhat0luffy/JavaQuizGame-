
import java.util.ArrayList;
import java.util.List;

public class QuizService {
    private List<Question> questions;

    public QuizService() {
        questions = new ArrayList<>();
        loadQuestions();
    }

    private void loadQuestions() {
        questions.add(new Question(
            "What is the capital of France?",
            new String[]{"Berlin", "London", "Paris", "Rome"},
            2
        ));
        questions.add(new Question(
            "Which planet is known as the Red Planet?",
            new String[]{"Earth", "Mars", "Jupiter", "Venus"},
            1
        ));
        questions.add(new Question(
            "Who wrote 'Romeo and Juliet'?",
            new String[]{"Charles Dickens", "William Shakespeare", "Mark Twain", "Jane Austen"},
            1
        ));
    }

    public List<Question> getQuestions() {
        return questions;
    }
}

