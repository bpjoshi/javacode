package com.bpjoshi.designpatterns.java8;

/**
 * @author Bhagwati Prasad
 * Sample Computer Bean that represents machine temperature in Celcius
 */
public class Computer {
    private int temperatureCelcius;

    public int getTemperatureCelcius() {
        return temperatureCelcius;
    }

    public Computer(int temperatureCelcius) {

        this.temperatureCelcius = temperatureCelcius;
    }
}
