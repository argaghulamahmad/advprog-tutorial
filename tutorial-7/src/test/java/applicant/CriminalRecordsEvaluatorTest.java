package applicant;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CriminalRecordsEvaluatorTest {
    private Applicant applicant;
    private Applicant anotherApplicant;
    private CriminalRecordsEvaluator criminalRecordsEvaluator;

    @Before
    public void setUp() {
        applicant = new Applicant();
        criminalRecordsEvaluator =
                new CriminalRecordsEvaluator(
                    new CreditEvaluator(
                        new EmploymentEvaluator(new QualifiedEvaluator())));

        anotherApplicant = mock(Applicant.class);
        when(anotherApplicant.hasCriminalRecord()).thenReturn(false);
        when(anotherApplicant.getCreditScore()).thenReturn(700);
        when(anotherApplicant.getEmploymentYears()).thenReturn(10);
        when(anotherApplicant.isCredible()).thenReturn(true);
    }

    @Test
    public void testCreditEvaluatorEvaluateMethod() {
        assertFalse(criminalRecordsEvaluator.evaluate(applicant));
        assertTrue(criminalRecordsEvaluator.evaluate(anotherApplicant));
    }
}