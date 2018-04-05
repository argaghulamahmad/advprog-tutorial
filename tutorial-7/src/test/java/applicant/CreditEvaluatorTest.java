package applicant;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

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