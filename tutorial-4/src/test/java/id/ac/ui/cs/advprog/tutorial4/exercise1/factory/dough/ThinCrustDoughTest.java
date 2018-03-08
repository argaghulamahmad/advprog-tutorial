package id.ac.ui.cs.advprog.tutorial4.exercise1.factory.dough;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ThinCrustDoughTest {
    private Dough dough;

    @Before
    public void setUp() {
        dough = new ThinCrustDough();
    }

    @Test
    public void testThinCrustDoughToStringMethod() {
        assertEquals(dough.toString(), "Thin Crust Dough");
    }
}