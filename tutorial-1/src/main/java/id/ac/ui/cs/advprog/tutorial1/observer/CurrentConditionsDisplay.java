package id.ac.ui.cs.advprog.tutorial1.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * CurrentConditionsDisplay merupakan Observer yang mengimplementasikan interface DisplayElement.
 * Class ini berguna untuk menampilkan dan memperbaharui data cuaca.
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {

    private Observable observable;
    private float temperature;
    private float humidity;

    public Observable getObservable() {
        return observable;
    }

    public void setObservable(Observable observable) {
        this.observable = observable;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public CurrentConditionsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature
                + "F degrees and " + humidity + "% humidity");
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            this.setTemperature(weatherData.getTemperature());
            this.setHumidity(weatherData.getHumidity());
            display();
        }
    }
}
