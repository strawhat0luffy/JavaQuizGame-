import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class QuizGameGUI extends JFrame {
    private QuizService quizService;
    private List<Question> questions;
    private int currentQuestionIndex = 0;
    private int score = 0;

    private JLabel questionLabel;
    private JButton[] optionButtons;
    private JLabel feedbackLabel;
    private JButton nextButton;

    public QuizGameGUI() {
        quizService = new QuizService();
        questions = quizService.getQuestions();
        setTitle("Java Quiz Game");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        questionLabel = new JLabel("", SwingConstants.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(questionLabel, BorderLayout.NORTH);

        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(4, 1));
        optionButtons = new JButton[4];
        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new JButton();
            optionButtons[i].setFont(new Font("Arial", Font.PLAIN, 14));
            int idx = i;
            optionButtons[i].addActionListener(e -> checkAnswer(idx));
            optionsPanel.add(optionButtons[i]);
        }
        add(optionsPanel, BorderLayout.CENTER);

        feedbackLabel = new JLabel("", SwingConstants.CENTER);
        feedbackLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        add(feedbackLabel, BorderLayout.SOUTH);

        nextButton = new JButton("Next");
        nextButton.setEnabled(false);
        nextButton.addActionListener(e -> nextQuestion());
        add(nextButton, BorderLayout.EAST);

        showQuestion();
    }

    private void showQuestion() {
        if (currentQuestionIndex < questions.size()) {
            Question q = questions.get(currentQuestionIndex);
            questionLabel.setText("Q" + (currentQuestionIndex + 1) + ": " + q.getQuestionText());
            String[] options = q.getOptions();
            for (int i = 0; i < optionButtons.length; i++) {
                optionButtons[i].setText(options[i]);
                optionButtons[i].setEnabled(true);
            }
            feedbackLabel.setText("");
            nextButton.setEnabled(false);
        } else {
            questionLabel.setText("Quiz finished!");
            for (JButton btn : optionButtons) {
                btn.setVisible(false);
            }
            feedbackLabel.setText("Your score: " + score + "/" + questions.size());
            nextButton.setVisible(false);
        }
    }

    private void checkAnswer(int selectedIndex) {
        Question q = questions.get(currentQuestionIndex);
        for (JButton btn : optionButtons) {
            btn.setEnabled(false);
        }
        if (selectedIndex == q.getCorrectOptionIndex()) {
            feedbackLabel.setText("Correct!");
            score++;
        } else {
            feedbackLabel.setText("Incorrect. Correct: " + q.getOptions()[q.getCorrectOptionIndex()]);
        }
        nextButton.setEnabled(true);
    }

    private void nextQuestion() {
        currentQuestionIndex++;
        showQuestion();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new QuizGameGUI().setVisible(true);
        });
    }
}
