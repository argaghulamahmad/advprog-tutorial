package id.ac.ui.cs.advprog.tutorial4.exercise1;

import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.DepokIngredientFactory;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.PizzaIngredientFactory;
import id.ac.ui.cs.advprog.tutorial4.exercise1.pizza.CheesePizza;
import id.ac.ui.cs.advprog.tutorial4.exercise1.pizza.ClamPizza;
import id.ac.ui.cs.advprog.tutorial4.exercise1.pizza.Pizza;
import id.ac.ui.cs.advprog.tutorial4.exercise1.pizza.VeggiePizza;

public class DepokPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String item) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new DepokIngredientFactory();

        if ("cheese".equals(item)) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("Pizza Keju Depok");

        } else if ("veggie".equals(item)) {
            pizza = new VeggiePizza(ingredientFactory);
            pizza.setName("Pizza Sayur Depok");

        } else if ("clam".equals(item)) {
            pizza = new ClamPizza(ingredientFactory);
            pizza.setName("Pizza Seafood Depok");

        }

        return pizza;
    }
}
