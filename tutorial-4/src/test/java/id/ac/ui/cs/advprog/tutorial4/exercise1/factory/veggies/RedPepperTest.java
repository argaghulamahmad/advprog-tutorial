package id.ac.ui.cs.advprog.tutorial4.exercise1.factory.veggies;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RedPepperTest {
    private Veggies veggies;

    @Before
    public void setUp() {
        veggies = new RedPepper();
    }

    @Test
    public void testRedPepperToStringMethod() {
        assertEquals(veggies.toString(), "Red Pepper");
    }
}