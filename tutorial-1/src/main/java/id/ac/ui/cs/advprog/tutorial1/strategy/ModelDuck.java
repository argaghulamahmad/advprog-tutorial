package id.ac.ui.cs.advprog.tutorial1.strategy;

public class ModelDuck extends Duck {
    public ModelDuck() {
        setFlyBehavior(new FlyNoWay());
        setQuackBehavior(new Quack());
    }

    public void display() {
        System.out.println("Aku bebek tiruan");
    }
}
