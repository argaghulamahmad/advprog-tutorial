package id.ac.ui.cs.advprog.tutorial4.exercise1.factory.sauce;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ChiliSauceTest {
    private Sauce sauce;

    @Before
    public void setUp() {
        sauce = new ChiliSauce();
    }

    @Test
    public void testChiliSauceToStringMethod() {
        assertEquals(sauce.toString(), "Chili Sauce");
    }
}