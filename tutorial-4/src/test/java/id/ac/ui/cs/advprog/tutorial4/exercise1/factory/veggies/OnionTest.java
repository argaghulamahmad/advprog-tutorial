package id.ac.ui.cs.advprog.tutorial4.exercise1.factory.veggies;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OnionTest {
    private Veggies veggies;

    @Before
    public void setUp() {
        veggies = new Onion();
    }

    @Test
    public void testOnionToStringMethod() {
        assertEquals(veggies.toString(), "Onion");
    }
}