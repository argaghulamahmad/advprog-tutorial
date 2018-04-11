package id.ac.ui.cs.advprog.tutorial3.decorator.bread;

import id.ac.ui.cs.advprog.tutorial3.decorator.Food;

public class CrustySandwich extends Food {
    public CrustySandwich() {

    }

    @Override
    public double cost() {
        return 1.00;
    }

    @Override
    public String getDescription() {
        return "Crusty Sandwich";
    }
}
