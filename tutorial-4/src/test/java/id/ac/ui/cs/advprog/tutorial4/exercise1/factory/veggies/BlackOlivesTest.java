package id.ac.ui.cs.advprog.tutorial4.exercise1.factory.veggies;

import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.sauce.ChiliSauce;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.sauce.Sauce;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BlackOlivesTest {
    private Veggies veggies;

    @Before
    public void setUp() {
        veggies = new BlackOlives();
    }

    @Test
    public void testBlackOlivesToStringMethod() {
        assertEquals(veggies.toString(), "Black Olives");
    }
}