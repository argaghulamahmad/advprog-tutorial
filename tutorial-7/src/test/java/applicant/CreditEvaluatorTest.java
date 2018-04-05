package applicant;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CreditEvaluatorTest {
    private Applicant applicant;
    private Applicant anotherApplicant;
    private CreditEvaluator creditEvaluator;

    @Before
    public void setUp() {
        applicant = new Applicant();
        creditEvaluator = new CreditEvaluator(new EmploymentEvaluator(new QualifiedEvaluator()));

        anotherApplicant = mock(Applicant.class);
        when(anotherApplicant.isCredible()).thenReturn(false);
    }

    @Test
    public void testCreditEvaluatorEvaluateMethod() {
        assertTrue(creditEvaluator.evaluate(applicant));
        assertFalse(creditEvaluator.evaluate(anotherApplicant));
    }
}