package applicant;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EmploymentEvaluatorTest {
    private Applicant applicant;
    private Applicant anotherApplicant;
    private EmploymentEvaluator employmentEvaluator;

    @Before
    public void setUp() {
        applicant = new Applicant();
        employmentEvaluator = new EmploymentEvaluator(new QualifiedEvaluator());

        anotherApplicant = mock(Applicant.class);
        when(anotherApplicant.getEmploymentYears()).thenReturn(0);
    }

    @Test
    public void testCreditEvaluatorEvaluateMethod() {
        assertTrue(employmentEvaluator.evaluate(applicant));
        assertFalse(employmentEvaluator.evaluate(anotherApplicant));
    }
}