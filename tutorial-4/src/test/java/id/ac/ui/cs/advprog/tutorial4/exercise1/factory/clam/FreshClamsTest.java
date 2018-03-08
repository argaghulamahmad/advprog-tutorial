package id.ac.ui.cs.advprog.tutorial4.exercise1.factory.clam;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FreshClamsTest {
    private Clams clams;

    @Before
    public void setUp() {
        clams = new FreshClams();
    }

    @Test
    public void testFreshClamsToStringMethod() {
        assertEquals(clams.toString(), "Fresh Clams from Long Island Sound");
    }
}