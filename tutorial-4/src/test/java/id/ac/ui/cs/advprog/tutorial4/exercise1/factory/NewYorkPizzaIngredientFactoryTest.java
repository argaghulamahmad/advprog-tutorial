package id.ac.ui.cs.advprog.tutorial4.exercise1.factory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.cheese.Cheese;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.cheese.ReggianoCheese;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.clam.Clams;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.clam.FreshClams;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.dough.Dough;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.dough.ThinCrustDough;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.sauce.MarinaraSauce;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.sauce.Sauce;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.veggies.Garlic;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.veggies.Mushroom;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.veggies.Onion;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.veggies.RedPepper;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.veggies.Veggies;
import org.junit.Before;
import org.junit.Test;

public class NewYorkPizzaIngredientFactoryTest {
    private PizzaIngredientFactory factory;

    @Before
    public void setUp() {
        factory = new NewYorkPizzaIngredientFactory();
    }

    @Test
    public void testCreateDoughMethod() {
        Dough dough = factory.createDough();
        assertNotNull(dough);
        assertTrue(dough instanceof ThinCrustDough);
    }

    @Test
    public void testCreateSauce() {
        Sauce sauce = factory.createSauce();
        assertNotNull(sauce);
        assertTrue(sauce instanceof MarinaraSauce);
    }

    @Test
    public void testCreateCheese() {
        Cheese cheese = factory.createCheese();
        assertNotNull(cheese);
        assertTrue(cheese instanceof ReggianoCheese);
    }

    @Test
    public void testCreateVeggies() {
        Veggies[] veggies = factory.createVeggies();
        assertNotNull(veggies);
        for (int i = 0; i < veggies.length; i++) {
            Object obj = veggies[i];
            if (i==0) {
                assertTrue(obj instanceof Garlic);
            } else if (i==1) {
                assertTrue(obj instanceof Onion);
            } else if (i==2) {
                assertTrue(obj instanceof Mushroom);
            } else if (i==3) {
                assertTrue(obj instanceof RedPepper);
            }
        }
    }

    @Test
    public void testCreateClams() {
        Clams clam = factory.createClam();
        assertNotNull(clam);
        assertTrue(clam instanceof FreshClams);
    }
}