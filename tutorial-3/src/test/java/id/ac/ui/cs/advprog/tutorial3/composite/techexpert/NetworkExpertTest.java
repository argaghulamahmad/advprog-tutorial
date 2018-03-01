package id.ac.ui.cs.advprog.tutorial3.composite.techexpert;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NetworkExpertTest {
    private NetworkExpert networkExpert;

    @Before
    public void setUp() {
        networkExpert = new NetworkExpert("Brook", 200000.00);
    }

    @Test
    public void testMethodCost() {
        assertEquals(200000.00, networkExpert.getSalary(), 0.00);
    }

    @Test
    public void testMethodGetName() {
        assertEquals("Brook", networkExpert.getName());
    }

    @Test
    public void testMethodGetRole() {
        assertEquals("Network Expert", networkExpert.getRole());
    }
}
