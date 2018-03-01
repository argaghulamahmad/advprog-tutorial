package id.ac.ui.cs.advprog.tutorial3.decorator.filling;

import id.ac.ui.cs.advprog.tutorial3.decorator.Food;

public class TomatoSauce extends Food {
    Food food;

    public TomatoSauce(Food food) {
        this.food = food;
    }

    @Override
    public String getDescription() {
        return "Thin Bun Burger, adding tomato sauce";
    }

    @Override
    public double cost() {
        return 1.70;
    }
}
