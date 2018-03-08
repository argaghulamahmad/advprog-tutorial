package id.ac.ui.cs.advprog.tutorial4.exercise1.factory.veggies;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MushroomTest {
    private Veggies veggies;

    @Before
    public void setUp() {
        veggies = new Mushroom();
    }

    @Test
    public void testMushroomToStringMethod() {
        assertEquals(veggies.toString(), "Mushrooms");
    }
}