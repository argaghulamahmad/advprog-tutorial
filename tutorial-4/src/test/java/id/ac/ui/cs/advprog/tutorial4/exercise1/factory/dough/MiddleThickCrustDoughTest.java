package id.ac.ui.cs.advprog.tutorial4.exercise1.factory.dough;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MiddleThickCrustDoughTest {
    private Dough dough;

    @Before
    public void setUp() {
        dough = new MiddleThickCrustDough();
    }

    @Test
    public void testMiddleThickCrustDoughToStringMethod() {
        assertEquals(dough.toString(), "Middle Thick Crust Dough");
    }
}