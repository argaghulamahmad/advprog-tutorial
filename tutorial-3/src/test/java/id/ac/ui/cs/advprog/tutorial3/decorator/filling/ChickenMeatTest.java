package id.ac.ui.cs.advprog.tutorial3.decorator.filling;

import id.ac.ui.cs.advprog.tutorial3.decorator.bread.ThinBunBurger;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChickenMeatTest {
    private ChickenMeat thinBunChickenMeatBurger;

    @Before
    public void setUp() {
        thinBunChickenMeatBurger = new ChickenMeat(new ThinBunBurger());
    }

    @Test
    public void testMethodCost() {
        assertEquals(6.00, thinBunChickenMeatBurger.cost(), 0.00);
    }

    @Test
    public void testMethodGetDescription() {
        assertEquals("Thin Bun Burger, adding chicken meat",
                thinBunChickenMeatBurger.getDescription());
    }
}
