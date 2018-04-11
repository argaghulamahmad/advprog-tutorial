package id.ac.ui.cs.advprog.tutorial3.decorator.bread;

import id.ac.ui.cs.advprog.tutorial3.decorator.Food;

public class ThinBunBurger extends Food {
    public ThinBunBurger() {

    }

    @Override
    public String getDescription() {
        return "Thin Bun Burger";
    }

    @Override
    public double cost() {
        return 1.50;
    }
}
