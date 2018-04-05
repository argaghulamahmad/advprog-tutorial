package applicant;

import java.util.function.Predicate;

/**
 * 4th exercise.
 */
public class Applicant {

    public boolean isCredible() {
        return true;
    }

    public int getCreditScore() {
        return 700;
    }

    public int getEmploymentYears() {
        return 10;
    }

    public boolean hasCriminalRecord() {
        return true;
    }

    /*
    //imperative programming
    public static boolean evaluate(Applicant applicant, Evaluator evaluator) {
        return evaluator.evaluate(applicant);
    }*/

    public static boolean evaluate(Applicant applicant, Predicate<Applicant> evaluator) {
        return applicant.isCredible() && evaluator.test(applicant);
    }

    private static void printEvaluation(boolean result) {
        String msg = "Result of evaluating applicant: %s";
        msg = result ? String.format(msg, "accepted") : String.format(msg, "rejected");

        System.out.println(msg);
    }

    public static void main(String[] args) {
        /*
        //imperative programming
        Applicant applicant = new Applicant();
        printEvaluation(evaluate(applicant, new CreditEvaluator(new QualifiedEvaluator())));
        printEvaluation(evaluate(applicant,
                new CreditEvaluator(new EmploymentEvaluator(new QualifiedEvaluator()))));
        printEvaluation(evaluate(applicant,
                new CriminalRecordsEvaluator(
                        new EmploymentEvaluator(new QualifiedEvaluator()))));
        printEvaluation(evaluate(applicant,
                new CriminalRecordsEvaluator(
                        new CreditEvaluator(
                                new EmploymentEvaluator(new QualifiedEvaluator())))));
        */

        Applicant applicant = new Applicant();

        Predicate<Applicant> creditCheck =
            theApplicant -> theApplicant.getCreditScore() > 600;

        Predicate<Applicant> employmentCheck =
            theApplicant -> theApplicant.getEmploymentYears() > 0;

        Predicate<Applicant> crimeCheck =
            theApplicant -> !theApplicant.hasCriminalRecord();

        printEvaluation(evaluate(applicant, creditCheck));

        printEvaluation(evaluate(applicant, creditCheck.and(employmentCheck)));

        printEvaluation(evaluate(applicant, crimeCheck.and(employmentCheck)));

        printEvaluation(evaluate(applicant, crimeCheck.and(creditCheck).and(employmentCheck)));
    }
}
