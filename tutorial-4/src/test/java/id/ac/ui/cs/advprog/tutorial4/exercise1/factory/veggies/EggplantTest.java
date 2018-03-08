package id.ac.ui.cs.advprog.tutorial4.exercise1.factory.veggies;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EggplantTest {
    private Veggies veggies;

    @Before
    public void setUp() {
        veggies = new Eggplant();
    }

    @Test
    public void testEggplantToStringMethod() {
        assertEquals(veggies.toString(), "Eggplant");
    }
}