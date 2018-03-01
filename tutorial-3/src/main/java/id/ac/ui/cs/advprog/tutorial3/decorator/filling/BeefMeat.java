package id.ac.ui.cs.advprog.tutorial3.decorator.filling;

import id.ac.ui.cs.advprog.tutorial3.decorator.Food;

public class BeefMeat extends Food {
    Food food;

    public BeefMeat(Food food) {
        this.food = food;
    }

    @Override
    public String getDescription() {
        return "Crusty Sandwich, adding beef meat";
    }

    @Override
    public double cost() {
        return 7.00;
    }
}
