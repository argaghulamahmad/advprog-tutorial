package id.ac.ui.cs.advprog.tutorial3.composite.techexpert;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BackendProgrammerTest {
    private BackendProgrammer backendProgrammer;

    @Before
    public void setUp() {
        backendProgrammer = new BackendProgrammer("Brook", 200000.00);
    }

    @Test
    public void testMethodCost() {
        assertEquals(200000.00, backendProgrammer.getSalary(), 0.00);
    }

    @Test
    public void testMethodGetName() {
        assertEquals("Brook", backendProgrammer.getName());
    }

    @Test
    public void testMethodGetRole() {
        assertEquals("Back End Programmer", backendProgrammer.getRole());
    }
}
