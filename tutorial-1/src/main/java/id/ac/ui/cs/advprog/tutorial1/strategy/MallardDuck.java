package id.ac.ui.cs.advprog.tutorial1.strategy;

public class MallardDuck extends Duck {
    public MallardDuck() {
        setQuackBehavior(new Quack());
        setFlyBehavior(new FlyWithWings());
    }

    public void display() {
        System.out.println("Aku bebek Mallard");
    }
}
