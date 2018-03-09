package id.ac.ui.cs.advprog.tutorial4.exercise1;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import id.ac.ui.cs.advprog.tutorial4.exercise1.pizza.Pizza;
import id.ac.ui.cs.advprog.tutorial4.exercise1.pizza.VeggiePizza;
import org.junit.Before;
import org.junit.Test;

public class PizzaStoreTest {
    private PizzaStore store;
    private Pizza pizza;

    @Before
    public void setUp() {
        store = new DepokPizzaStore();
    }

    @Test
    public void testPrepareMethod() {
        pizza = store.orderPizza("veggie");
        assertNotNull(pizza);
        assertTrue(pizza instanceof VeggiePizza);
    }
}