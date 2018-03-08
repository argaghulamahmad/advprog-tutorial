package id.ac.ui.cs.advprog.tutorial4.exercise1.pizza;

import static org.junit.jupiter.api.Assertions.assertTrue;

import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.PizzaIngredientFactory;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.cheese.Cheese;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.cheese.ParmesanCheese;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.clam.Clams;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.clam.FreshClams;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.dough.Dough;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.dough.ThinCrustDough;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.sauce.PlumTomatoSauce;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.sauce.Sauce;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.veggies.Veggies;
import org.junit.Before;
import org.junit.Test;

public class ClamPizzaTest {
    private Pizza pizza;
    private PizzaIngredientFactory factory;

    @Before
    public void setUp() {
        factory = new PizzaIngredientFactory() {
            @Override
            public Dough createDough() {
                return new ThinCrustDough();
            }

            @Override
            public Sauce createSauce() {
                return new PlumTomatoSauce();
            }

            @Override
            public Cheese createCheese() {
                return new ParmesanCheese();
            }

            @Override
            public Veggies[] createVeggies() {
                return new Veggies[0];
            }

            @Override
            public Clams createClam() {
                return new FreshClams();
            }
        };

        pizza = new ClamPizza(factory);
        pizza.setName("Pizza Kerang buatan ARGA");
    }

    @Test
    public void testPrepareMethod() {
        pizza.prepare();
        assertTrue(pizza.dough instanceof ThinCrustDough);
        assertTrue(pizza.sauce instanceof PlumTomatoSauce);
        assertTrue(pizza.cheese instanceof ParmesanCheese);
        assertTrue(pizza.clam instanceof FreshClams);
    }
}
