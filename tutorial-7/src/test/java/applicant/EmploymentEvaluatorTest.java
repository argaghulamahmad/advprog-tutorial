package applicant;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

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