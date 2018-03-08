package id.ac.ui.cs.advprog.tutorial4.exercise1.factory.dough;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ThickCrustDoughTest {
    private Dough dough;

    @Before
    public void setUp() {
        dough = new ThickCrustDough();
    }

    @Test
    public void testThickCrustDoughToStringMethod() {
        assertEquals(dough.toString(), "ThickCrust style extra thick crust dough");
    }
}