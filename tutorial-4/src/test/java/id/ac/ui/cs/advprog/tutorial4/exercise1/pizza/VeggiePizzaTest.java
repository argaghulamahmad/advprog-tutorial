package id.ac.ui.cs.advprog.tutorial4.exercise1.pizza;

import static org.junit.jupiter.api.Assertions.assertTrue;

import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.PizzaIngredientFactory;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.cheese.Cheese;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.cheese.MozzarellaCheese;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.clam.Clams;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.clam.HotClams;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.dough.Dough;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.dough.ThickCrustDough;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.sauce.ChiliSauce;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.sauce.Sauce;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.veggies.Carrot;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.veggies.Veggies;
import org.junit.Before;
import org.junit.Test;

public class VeggiePizzaTest {
    private Pizza pizza;
    private PizzaIngredientFactory factory;

    @Before
    public void setUp() {
        factory = new PizzaIngredientFactory() {
            @Override
            public Dough createDough() {
                return new ThickCrustDough();
            }

            @Override
            public Sauce createSauce() {
                return new ChiliSauce();
            }

            @Override
            public Cheese createCheese() {
                return new MozzarellaCheese();
            }

            @Override
            public Veggies[] createVeggies() {
                return new Veggies[]{new Carrot()};
            }

            @Override
            public Clams createClam() {
                return new HotClams();
            }
        };

        pizza = new VeggiePizza(factory);
        pizza.setName("Pizza Sayur buatan ARGA");
    }

    @Test
    public void testPrepareMethod() {
        pizza.prepare();
        assertTrue(pizza.dough instanceof ThickCrustDough);
        assertTrue(pizza.sauce instanceof ChiliSauce);
        assertTrue(pizza.cheese instanceof MozzarellaCheese);
        assertTrue(pizza.veggies[0] instanceof Carrot);
    }
}