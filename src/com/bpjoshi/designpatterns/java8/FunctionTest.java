package com.bpjoshi.designpatterns.java8;

/**
 * @author Bhagwati Prasad
 * Chaining functions to calculate values
 */
public class FunctionTest {
    public static void main(String[] args) {
        //Maps computer Object to its temperature
        Function<Computer, Integer> celciusTemperature=comp->comp.getTemperatureCelcius();
        //Maps celcius temprature to fahrenheit
        Function<Integer, Double> celciusToFahrenheit=celc->celc*(9d/5d)+32d;
        //chaining two functions
        Function<Computer, Double> fahrenheitTemperature=celciusTemperature.andThen(celciusToFahrenheit);

        Computer computer= new Computer(30);
        //apply our chained function
        Double resultTemp = fahrenheitTemperature.apply(computer);
        System.out.println(resultTemp);
    }
}
