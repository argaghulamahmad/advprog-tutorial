package id.ac.ui.cs.advprog.tutorial1.strategy;

/**
 * Abstract class Duck yang merepresentasikan Bebek
 */
public abstract class Duck {
    /**
     * Instance variable yang berupa Interface agar bisa diassign
     * dengan class yang mengimplementasikan interface FlyBehaviour dan QuackBehaviour.
     */
    private FlyBehavior flyBehavior;
    private QuackBehavior quackBehavior;

    /**
     * Method perform fly ditujukan apabila kelas yang mengextends class Duck bisa terbang
     * sesuai dengan kemampuan terbang yang diinginkan.
     */
    public void performFly() {
        flyBehavior.fly();
    }

    /**
     * Method perform quack ditujukan apabila kelas yang mengextends class Duck bisa berbunyi
     * sesuai dengan kemampuan quack yang diinginkan.
     */
    public void performQuack() {
        quackBehavior.quack();
    }

    public FlyBehavior getFlyBehavior() {
        return flyBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public QuackBehavior getQuackBehavior() {
        return quackBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    /**
     * Method display yang akan diimplementasikan oleh class yang mengextends class Duck,
     * menampilkan informasi mengenai masing-masing class yang mengimplementasikan class Duck.
     */
    public abstract void display();

    /**
     * Method untuk menampilkan informasi bahwa Bebek berenang.
     */
    public void swim() {
        System.out.println("Bebek ini berenang.");
    }
}
