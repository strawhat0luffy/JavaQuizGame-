# Java Quiz Game

This is a simple console-based Quiz Game built in Java. The game presents multiple-choice questions, accepts user input, and displays the final score.

## Features
- Multiple-choice questions
- Instant feedback on answers
- Score calculation

## How to Run
1. Make sure you have Java installed (JDK 8 or above).
2. Compile the source files:
   ```
   javac src/*.java
   ```
3. Run the game:
   ```
   java -cp src QuizGame
   ```

## Project Structure
- `src/Question.java` - Represents a quiz question
- `src/QuizService.java` - Loads and manages questions
- `src/QuizGame.java` - Main class to run the game

## Example
```
Welcome to the Java Quiz Game!

Question 1: What is the capital of France?
1. Berlin
2. London
3. Paris
4. Rome
Your answer (1-4): 3
Correct!
...
Quiz finished! Your score: 3/3
```

## License
This project is for educational purposes.
