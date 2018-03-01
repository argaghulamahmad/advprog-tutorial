package id.ac.ui.cs.advprog.tutorial3.decorator.filling;

import id.ac.ui.cs.advprog.tutorial3.decorator.bread.NoCrustSandwich;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheeseTest {
    private Cheese noCrustCheesySandwich;

    @Before
    public void setUp() {
        noCrustCheesySandwich = new Cheese(new NoCrustSandwich());
    }

    @Test
    public void testMethodCost() {
        assertEquals(4.00, noCrustCheesySandwich.cost(), 0.00);
    }

    @Test
    public void testMethodGetDescription() {
        assertEquals("No Crust Sandwich, adding cheese",
                noCrustCheesySandwich.getDescription());
    }
}
