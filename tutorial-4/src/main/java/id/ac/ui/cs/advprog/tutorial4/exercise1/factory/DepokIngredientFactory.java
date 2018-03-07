package id.ac.ui.cs.advprog.tutorial4.exercise1.factory;

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

public class DepokIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new MiddleThickCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new ChiliSauce();
    }

    @Override
    public Cheese createCheese() {
        return new CamembertCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        return new Veggies[]{new Carrot(), new Onion(), new RedPepper(),
            new Garlic(), new Mushroom()};
    }

    @Override
    public Clams createClam() {
        return new HotClams();
    }
}
