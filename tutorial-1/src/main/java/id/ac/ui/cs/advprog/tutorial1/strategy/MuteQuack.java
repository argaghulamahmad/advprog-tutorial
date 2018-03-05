package id.ac.ui.cs.advprog.tutorial1.strategy;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Aku ora iso quack");
    }
}