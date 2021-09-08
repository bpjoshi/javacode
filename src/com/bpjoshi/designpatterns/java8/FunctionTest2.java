package com.bpjoshi.designpatterns.java8;

/**
 * @author Bhagwati Prasad
 * Composing the functions
 * unlike FunctionTest, composed first lambda will be passed as an argument
 * You cannot compose Predicates and Consumers, one returns only boolean and another doesn't return anything
 */
public class FunctionTest2 {
    public static void main(String[] args) {
        Function<Computer, Integer> celcTemp=comp->comp.getTemperatureCelcius();
        Function<Integer, Double> celcToFRNHT=celc->celc*(9d/5d)+32d;
        Function<Computer, Double> composedLambda=celcToFRNHT.compose(celcTemp);
        /*
        Note: for above
        celcToFRNHT -> T is Integer, R is double
        due to which Input is V type Computer and T Integer
        therefore return is V and R
        */
        Double resultTemp=composedLambda.apply(new Computer(20));
        System.out.println(resultTemp);
    }
}
