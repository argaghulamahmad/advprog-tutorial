package id.ac.ui.cs.advprog.tutorial4.exercise1.factory.cheese;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CamembertCheeseTest {
    private Cheese cheese;

    @Before
    public void setUp() throws Exception {
        cheese = new CamembertCheese();
    }

    @Test
    public void testCamembertCheeseToStringMethod() throws Exception {
        assertEquals(cheese.toString(), "Camembert Cheese");
    }
}