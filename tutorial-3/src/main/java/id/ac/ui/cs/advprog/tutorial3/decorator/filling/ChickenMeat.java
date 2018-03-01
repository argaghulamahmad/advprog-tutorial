package id.ac.ui.cs.advprog.tutorial3.decorator.filling;

import id.ac.ui.cs.advprog.tutorial3.decorator.Food;

public class ChickenMeat extends Food {
    Food food;

    public ChickenMeat(Food food) {
        this.food = food;
    }

    @Override
    public String getDescription() {
        return "Thin Bun Burger, adding chicken meat";
    }

    @Override
    public double cost() {
        return 6.00;
    }
}
