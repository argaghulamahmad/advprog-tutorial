package game;

/**
 * Created by billy on 9/27/16.
 * Edited by hafiyyan94 on 4/10/18
 * Modified by argaghulamahmad on 4/13/18
 */

public class Main {
    public static void main(String[] args) {
        QuizGenerator quizGenerator = new QuizGenerator();
        quizGenerator.start();

        QuizTimer quizTimer = new QuizTimer(quizGenerator);
        quizTimer.start();
    }
}
