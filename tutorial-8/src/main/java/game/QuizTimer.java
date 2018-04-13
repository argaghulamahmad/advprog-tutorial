package game;

public class QuizTimer implements Runnable {
    private Thread thread;
    private QuizGenerator quizGenerator;

    public QuizTimer(QuizGenerator quizGenerator) {
        this.quizGenerator = quizGenerator;
    }

    /**
     * Start QuizTimer thread
     */
    public void start() {
        if (thread == null) {
            thread = new Thread(this, "Quiz Timer");
            thread.start();
        }
    }

    @Override
    public void run() {
        while (!quizGenerator.isOver()) {
            while (quizGenerator.isStarted()) {
                try {
                    Thread.sleep(1000);
                    quizGenerator.decrementTotalPoint();
                } catch (InterruptedException ignored) {

                }
            }
        }
    }
}
