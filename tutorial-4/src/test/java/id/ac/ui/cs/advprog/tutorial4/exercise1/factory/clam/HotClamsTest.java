package id.ac.ui.cs.advprog.tutorial4.exercise1.factory.clam;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class HotClamsTest {
    private Clams clams;

    @Before
    public void setUp() {
        clams = new HotClams();
    }

    @Test
    public void testHotClamsToStringMethod() {
        assertEquals(clams.toString(), "Hot Clams from Tanjung Priuk Bay");
    }
}