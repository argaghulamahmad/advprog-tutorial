package id.ac.ui.cs.advprog.tutorial4.exercise1.factory.veggies;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CarrotTest {
    private Veggies veggies;

    @Before
    public void setUp() {
        veggies = new Carrot();
    }

    @Test
    public void testCarrotToStringMethod() {
        assertEquals(veggies.toString(), "Carrot");
    }
}