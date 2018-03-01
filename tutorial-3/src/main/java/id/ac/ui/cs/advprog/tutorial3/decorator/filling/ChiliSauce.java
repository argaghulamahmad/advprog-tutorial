package id.ac.ui.cs.advprog.tutorial3.decorator.filling;

import id.ac.ui.cs.advprog.tutorial3.decorator.Food;

public class ChiliSauce extends Food {
    Food food;

    public ChiliSauce(Food food) {
        this.food = food;
    }

    @Override
    public String getDescription() {
        return "Thick Bun Burger, adding chili sauce";
    }

    @Override
    public double cost() {
        return 2.80;
    }
}
