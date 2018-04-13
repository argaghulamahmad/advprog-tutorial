package game;

import java.util.Random;
import java.util.Scanner;

public class QuizGenerator implements Runnable {
    private static final int TOTAL_QUEST = 10;
    private static final int QUEST_TYPE_ADD = 0;
    private static final int QUEST_TYPE_SUBSTR = 1;
    private static final int QUEST_TYPE_MULTIPL = 2;
    private static final int QUEST_TYPE_DIVS = 3;

    private Thread thread;
    private int totalPoint;
    private boolean isOver = false;
    private boolean isStarted = false;

    /**
     * Start QuizGenerator thread
     */
    public void start() {
        if (thread == null) {
            thread = new Thread(this, "Generating Quiz Problem");
            thread.start();
        }
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String startNewQuestsIpt;
        int thresholdTime;
        int totalRightBelowThreshold;
        int totalRightAboveThreshold;
        int totalWrong;
        int totalTime;

        do {
            // Initialize values
            startNewQuestsIpt = "";
            totalRightBelowThreshold = 0;
            totalRightAboveThreshold = 0;
            totalWrong = 0;
            totalTime = 0;
            totalPoint = 100;

            // Asking for asnwering question threshold time
            System.out.print("How much time do you need "
                    + "to answer each question? (In second) ");
            String rawInput = scanner.nextLine();
            thresholdTime = rawInput.isEmpty() ? 20 : Integer.parseInt(rawInput);

            setIsStarted(true);

            for (int questNo = 1; questNo <= TOTAL_QUEST; questNo++) {
                System.out.print(questNo + ") ");
                Random rand = new Random();
                Fraction firstPosFrac = new Fraction(rand.nextInt(40) - 20,
                        rand.nextInt(40) - 20);
                Fraction secondPosFrac = new Fraction(rand.nextInt(40) - 20,
                        rand.nextInt(40) - 20);
                Fraction expectedAnswer;

                switch (rand.nextInt(3)) {
                    case QUEST_TYPE_ADD:
                        System.out.print(firstPosFrac.toString() + "  +  "
                                + secondPosFrac.toString() + "  =  ");
                        expectedAnswer = firstPosFrac.getAddition(secondPosFrac);
                        break;
                    case QUEST_TYPE_SUBSTR:
                        System.out.print(firstPosFrac.toString() + "  -  "
                                + secondPosFrac.toString() + "  =  ");
                        expectedAnswer = firstPosFrac.getSubstraction(secondPosFrac);
                        break;
                    case QUEST_TYPE_MULTIPL:
                        System.out.print(firstPosFrac.toString() + "  *  "
                                + secondPosFrac.toString() + "  =  ");
                        expectedAnswer = firstPosFrac.getMultiplication(secondPosFrac);
                        break;
                    case QUEST_TYPE_DIVS:
                        System.out.print(firstPosFrac.toString() + "  :  "
                                + secondPosFrac.toString() + "  =  ");
                        expectedAnswer = firstPosFrac.getDivision(secondPosFrac);
                        break;
                    default:
                        System.out.println("Oooops!");
                        expectedAnswer = new Fraction();
                }

                // Asking for question
                // And capture before and after the time in milis
                long totalMilis = System.currentTimeMillis();
                String rawAns = scanner.nextLine();
                totalMilis = System.currentTimeMillis() - totalMilis;
                totalTime += totalMilis;

                // Process user answer
                Fraction userAnswer;
                if (rawAns.contains("/")) {
                    String[] ans = rawAns.split("/");
                    userAnswer = new Fraction(Integer.parseInt(ans[0]),
                            Integer.parseInt(ans[1]));
                } else {
                    userAnswer = new Fraction(Integer.parseInt(rawAns));
                }

                // Check answer
                if (expectedAnswer.isEqual(userAnswer)) {
                    if (totalMilis / 1000 <= thresholdTime) {
                        totalRightBelowThreshold++;
                        addTotalPointBelowThreshold(totalPoint * 0.1);
                    } else {
                        totalRightAboveThreshold++;
                        addTotalPointAboveThreshold(totalPoint * 0.05);
                    }
                } else {
                    totalWrong++;
                }

                System.out.println("Current Score : " + totalPoint);
                System.out.println("Time Needed : " + totalMilis + " milisecond(s)");
            }

            setIsStarted(false);

            // Print the result
            System.out.println("\n=========Result==========");
            System.out.println("Right answer and within time limit  =  "
                    + totalRightBelowThreshold);
            System.out.println("Right answer but over time limit  =  "
                    + totalRightAboveThreshold);
            System.out.println("Wrong answer  =  " + totalWrong);

            System.out.println("\nTotal point acquired : " + getTotalPoint());
            System.out.println("Total time needed : " + totalTime + " milisecond(s)");
            System.out.println("\n");

            // Asking if user want to start a new questions
            // if the respond is not what we want, ask it again and again
            while (!startNewQuestsIpt.equalsIgnoreCase("y")
                    && !startNewQuestsIpt.equalsIgnoreCase("n")) {
                System.out.println("Restart the quiz? [y/n]");
                startNewQuestsIpt = scanner.nextLine();
            }
            System.out.println("\n\n\n\n\n\n");
        } while (startNewQuestsIpt.equalsIgnoreCase("y"));
        // while user input yes, do same step again
        setIsOver(true);
    }

    /**
     * Decrease totalPoint synchronized
     */
    public synchronized void decrementTotalPoint() {
        totalPoint--;
    }

    /**
     * Add total point right below threshold point
     * @param RIGHT_BELOW_THRESHOLD_POINT point will be added to total point
     */
    public synchronized void addTotalPointBelowThreshold(double RIGHT_BELOW_THRESHOLD_POINT) {
        totalPoint += RIGHT_BELOW_THRESHOLD_POINT;
    }

    /**
     * Add total point right above threshold point
     * @param RIGHT_ABOVE_THRESHOLD_POINT point will be added to total point
     */
    public synchronized void addTotalPointAboveThreshold(double RIGHT_ABOVE_THRESHOLD_POINT) {
        totalPoint += RIGHT_ABOVE_THRESHOLD_POINT;
    }

    /**
     * Get instance var totalPoint
     * @return int totalPoint
     */
    public synchronized int getTotalPoint() {
        return totalPoint;
    }

    /**
     * Get instance var isOver
     * @return boolean isOver
     */
    public synchronized boolean isOver() {
        return isOver;
    }

    /**
     * Get instance var isStarted
     * @return boolean isStarted
     */
    public synchronized boolean isStarted() {
        return isStarted;
    }

    /**
     * Set instance var isOver value
     * @param flag boolean flag
     */
    public synchronized void setIsOver(boolean flag) {
        isOver = flag;
    }

    /**
     * Set instance var isStarted value
     * @param flag boolean flag
     */
    public synchronized void setIsStarted(boolean flag) {
        isStarted = flag;
    }
}
