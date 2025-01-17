package id.ac.ui.cs.advprog.tutorial3.decorator.filling;

import id.ac.ui.cs.advprog.tutorial3.decorator.Food;

public class BeefMeat extends Food {
    Food food;

    public BeefMeat(Food food) {
        this.food = food;
    }

    @Override
    public String getDescription() {
        return this.food.getDescription() + ", adding beef meat";
    }

    @Override
    public double cost() {
        return 6.00 + this.food.cost();
    }
}
