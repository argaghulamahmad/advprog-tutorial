package id.ac.ui.cs.advprog.tutorial4.exercise1.factory.sauce;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlumTomatoSauceTest {
    private Sauce sauce;

    @Before
    public void setUp() {
        sauce = new PlumTomatoSauce();
    }

    @Test
    public void testPlumTomateSauceToStringMethod() {
        assertEquals(sauce.toString(), "Tomato sauce with plum tomatoes");
    }
}