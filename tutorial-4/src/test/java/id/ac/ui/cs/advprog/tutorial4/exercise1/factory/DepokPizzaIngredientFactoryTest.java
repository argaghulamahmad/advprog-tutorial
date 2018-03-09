package id.ac.ui.cs.advprog.tutorial4.exercise1.factory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.cheese.CamembertCheese;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.cheese.Cheese;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.clam.Clams;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.clam.HotClams;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.dough.Dough;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.dough.MiddleThickCrustDough;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.sauce.ChiliSauce;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.sauce.Sauce;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.veggies.Carrot;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.veggies.Garlic;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.veggies.Mushroom;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.veggies.Onion;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.veggies.RedPepper;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.veggies.Veggies;
import org.junit.Before;
import org.junit.Test;

public class DepokPizzaIngredientFactoryTest {
    private PizzaIngredientFactory factory;

    @Before
    public void setUp() {
        factory = new DepokPizzaIngredientFactory();
    }

    @Test
    public void testCreateDoughMethod() {
        Dough dough = factory.createDough();
        assertNotNull(dough);
        assertTrue(dough instanceof MiddleThickCrustDough);
    }

    @Test
    public void testCreateSauce() {
        Sauce sauce = factory.createSauce();
        assertNotNull(sauce);
        assertTrue(sauce instanceof ChiliSauce);
    }

    @Test
    public void testCreateCheese() {
        Cheese cheese = factory.createCheese();
        assertNotNull(cheese);
        assertTrue(cheese instanceof CamembertCheese);
    }

    @Test
    public void testCreateVeggies() {
        Veggies[] veggies = factory.createVeggies();
        assertNotNull(veggies);
        for (int i = 0; i < veggies.length; i++) {
            Object obj = veggies[i];
            switch (i) {
                default:

                case 0:
                    assertTrue(obj instanceof Carrot);
                    break;
                case 1:
                    assertTrue(obj instanceof Onion);

                    break;
                case 2:
                    assertTrue(obj instanceof RedPepper);

                    break;
                case 3:
                    assertTrue(obj instanceof Garlic);

                    break;
                case 4:
                    assertTrue(obj instanceof Mushroom);

                    break;
            }
        }
    }

    @Test
    public void testCreateClams() {
        Clams clam = factory.createClam();
        assertNotNull(clam);
        assertTrue(clam instanceof HotClams);
    }
}