import java.util.List;
import java.util.Scanner;

public class QuizGame {
    public static void main(String[] args) {
        QuizService quizService = new QuizService();
        List<Question> questions = quizService.getQuestions();
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        System.out.println("Welcome to the Java Quiz Game!");
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("\nQuestion " + (i + 1) + ": " + q.getQuestionText());
            String[] options = q.getOptions();
            for (int j = 0; j < options.length; j++) {
                System.out.println((j + 1) + ". " + options[j]);
            }
            System.out.print("Your answer (1-" + options.length + "): ");
            int answer = scanner.nextInt();
            if (answer - 1 == q.getCorrectOptionIndex()) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is: " + options[q.getCorrectOptionIndex()]);
            }
        }
        System.out.println("\nQuiz finished! Your score: " + score + "/" + questions.size());
        scanner.close();
    }
}
