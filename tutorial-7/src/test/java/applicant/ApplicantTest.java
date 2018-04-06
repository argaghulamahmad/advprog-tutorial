package applicant;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.Predicate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ApplicantTest {
    private Applicant applicant;
    private Predicate<Applicant> creditCheck;
    private Predicate<Applicant> employmentCheck;
    private Predicate<Applicant> crimeCheck;
    private Method printEvaluationMethod;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Before
    public void setUp() throws NoSuchMethodException {
        applicant = new Applicant();
        creditCheck =
            theApplicant -> theApplicant.getCreditScore() > 600;

        employmentCheck =
            theApplicant -> theApplicant.getEmploymentYears() > 0;

        crimeCheck =
            theApplicant -> !theApplicant.hasCriminalRecord();

        printEvaluationMethod = Applicant.class.getDeclaredMethod("printEvaluation", boolean.class);
        printEvaluationMethod.setAccessible(true);
    }

    @Test
    public void testIsApplicantEvaluateMethodResultCorrect() {
        assertTrue(Applicant.evaluate(applicant, creditCheck));
        assertTrue(Applicant.evaluate(applicant, creditCheck.and(employmentCheck)));
        assertFalse(Applicant.evaluate(applicant, crimeCheck.and(employmentCheck)));
        assertFalse(Applicant.evaluate(applicant, crimeCheck.and(creditCheck)
                .and(employmentCheck)));
    }

    @Test
    public void testIsApplicantPrintEvaluationMethodResultAccepted()
            throws InvocationTargetException, IllegalAccessException {
        printEvaluationMethod.invoke(Applicant.class, true);
        assertEquals("Result of evaluating applicant: accepted\n",
                outContent.toString());
        assertNotEquals("", outContent.toString());
    }

    @Test
    public void testIsApplicantPrintEvaluationMethodResultRejected()
            throws InvocationTargetException, IllegalAccessException {
        printEvaluationMethod.invoke(Applicant.class, false);
        assertEquals("Result of evaluating applicant: rejected\n",
                outContent.toString());
        assertNotEquals("", outContent.toString());
    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
        System.setErr(System.err);
    }
}
