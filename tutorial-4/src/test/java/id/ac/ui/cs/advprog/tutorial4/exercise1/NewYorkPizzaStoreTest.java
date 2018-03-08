package id.ac.ui.cs.advprog.tutorial4.exercise1;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import id.ac.ui.cs.advprog.tutorial4.exercise1.pizza.CheesePizza;
import id.ac.ui.cs.advprog.tutorial4.exercise1.pizza.ClamPizza;
import id.ac.ui.cs.advprog.tutorial4.exercise1.pizza.Pizza;
import id.ac.ui.cs.advprog.tutorial4.exercise1.pizza.VeggiePizza;
import org.junit.Before;
import org.junit.Test;

public class NewYorkPizzaStoreTest {
    private PizzaStore store;
    private Pizza pizza;

    @Before
    public void setUp() {
        store = new NewYorkPizzaStore();
    }

    @Test
    public void testNewYorkStoreCreatePizzaMethod() {
        pizza = store.createPizza("veggie");
        assertNotNull(pizza);
        assertTrue(pizza instanceof VeggiePizza);
        pizza = store.createPizza("clam");
        assertNotNull(pizza);
        assertTrue(pizza instanceof ClamPizza);
        pizza = store.createPizza("cheese");
        assertNotNull(pizza);
        assertTrue(pizza instanceof CheesePizza);
    }
}
