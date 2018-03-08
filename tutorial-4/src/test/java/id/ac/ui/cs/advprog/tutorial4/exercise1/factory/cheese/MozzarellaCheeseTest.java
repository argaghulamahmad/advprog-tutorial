package id.ac.ui.cs.advprog.tutorial4.exercise1.factory.cheese;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MozzarellaCheeseTest {
    private Cheese cheese;

    @Before
    public void setUp() throws Exception {
        cheese = new MozzarellaCheese();
    }

    @Test
    public void testMozarellaCheseToStringMethod() throws Exception {
        assertEquals(cheese.toString(), "Shredded Mozzarella");
    }
}