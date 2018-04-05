package applicant;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.Predicate;

import static org.junit.Assert.*;

public class ApplicantTest {
    private Applicant applicant;
    private Predicate<Applicant> creditCheck;
    private Predicate<Applicant> employmentCheck;
    private Predicate<Applicant> crimeCheck;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Before
    public void setUp() {
        applicant = new Applicant();
        creditCheck =
            theApplicant -> theApplicant.getCreditScore() > 600;

        employmentCheck =
            theApplicant -> theApplicant.getEmploymentYears() > 0;

        crimeCheck =
            theApplicant -> !theApplicant.hasCriminalRecord();
    }

    @Test
    public void testIsApplicantEvaluateMethodResultCorrect() {
        assertTrue(Applicant.evaluate(applicant, creditCheck));
        assertTrue(Applicant.evaluate(applicant, creditCheck.and(employmentCheck)));
        assertFalse(Applicant.evaluate(applicant, crimeCheck.and(employmentCheck)));
        assertFalse(Applicant.evaluate(applicant, crimeCheck.and(creditCheck).and(employmentCheck)));
    }

    @Test
    public void testIsApplicantPrintEvaluationMethodResultAccepted() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException {
        Method method = Applicant.class.getDeclaredMethod("printEvaluation", boolean.class);
        method.setAccessible(true);
        method.invoke(Applicant.class, true);
        assertEquals("Result of evaluating applicant: accepted\r\n", outContent.toString());
    }

    @Test
    public void testIsApplicantPrintEvaluationMethodResultRejected() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException {
        Method method = Applicant.class.getDeclaredMethod("printEvaluation", boolean.class);
        method.setAccessible(true);
        method.invoke(Applicant.class, false);
        assertEquals("Result of evaluating applicant: rejected\r\n", outContent.toString());
    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
        System.setErr(System.err);
    }
}
