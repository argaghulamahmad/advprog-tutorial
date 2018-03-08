package id.ac.ui.cs.advprog.tutorial4.exercise1.factory.cheese;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ReggianoCheeseTest {
    private Cheese cheese;

    @Before
    public void setUp() throws Exception {
        cheese = new ReggianoCheese();
    }

    @Test
    public void testReggianoCheseToStringMethod() throws Exception {
        assertEquals(cheese.toString(), "Reggiano Cheese");
    }
}