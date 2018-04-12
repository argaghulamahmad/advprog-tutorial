package tallycounter;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * The new version of Tally Counter implemented by using AtomicInteger
 */
public class AtomicTallyCounter {
    //Create variable counter using atomic integer with initial value zero
    private AtomicInteger counter = new AtomicInteger(0);

    public void increment() {
        //Atomically increments by one the current value of counter
        counter.getAndIncrement();
    }

    public void decrement() {
        //Atomically decrement by one the current value of counter
        counter.getAndDecrement();
    }

    public int value() {
        //Get counter current value
        return counter.get();
    }
}
