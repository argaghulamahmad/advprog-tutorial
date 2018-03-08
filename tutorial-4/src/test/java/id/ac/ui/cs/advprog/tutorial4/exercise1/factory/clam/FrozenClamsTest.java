package id.ac.ui.cs.advprog.tutorial4.exercise1.factory.clam;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FrozenClamsTest {
    private Clams clams;

    @Before
    public void setUp() {
        clams = new FrozenClams();
    }

    @Test
    public void testFrozenClamsToStringMethod() {
        assertEquals(clams.toString(), "Frozen Clams from Chesapeake Bay");
    }
}