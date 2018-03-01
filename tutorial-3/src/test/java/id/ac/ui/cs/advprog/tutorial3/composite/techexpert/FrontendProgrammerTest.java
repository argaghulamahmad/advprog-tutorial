package id.ac.ui.cs.advprog.tutorial3.composite.techexpert;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FrontendProgrammerTest {
    private FrontendProgrammer frontendProgrammer;

    @Before
    public void setUp() {
        frontendProgrammer = new FrontendProgrammer("Brook", 200000.00);
    }

    @Test
    public void testMethodCost() {
        assertEquals(200000.00, frontendProgrammer.getSalary(), 0.00);
    }

    @Test
    public void testMethodGetName() {
        assertEquals("Brook", frontendProgrammer.getName());
    }

    @Test
    public void testMethodGetRole() {
        assertEquals("Front End Programmer", frontendProgrammer.getRole());
    }
}
