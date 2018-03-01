package id.ac.ui.cs.advprog.tutorial3.decorator.filling;

import id.ac.ui.cs.advprog.tutorial3.decorator.Food;

public class Tomato extends Food {
    Food food;

    public Tomato(Food food) {
        this.food = food;
    }

    @Override
    public String getDescription() {
        return "Thick Bun Burger, adding tomato";
    }

    @Override
    public double cost() {
        return 3.00;
    }
}
