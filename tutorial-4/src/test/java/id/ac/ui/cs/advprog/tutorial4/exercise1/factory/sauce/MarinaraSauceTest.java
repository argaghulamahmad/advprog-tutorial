package id.ac.ui.cs.advprog.tutorial4.exercise1.factory.sauce;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MarinaraSauceTest {
    private Sauce sauce;

    @Before
    public void setUp() {
        sauce = new MarinaraSauce();
    }

    @Test
    public void testMarinaraSauceToStringMethod() {
        assertEquals(sauce.toString(), "Marinara Sauce");
    }
}