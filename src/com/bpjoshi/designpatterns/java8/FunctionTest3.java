package com.bpjoshi.designpatterns.java8;

/**
 * @author Bhagwati Prasad
 * Static factory in sample Function interface
 */
public class FunctionTest3 {
    public static void main(String[] args) {
        //Function<String, String> identity=s->s;
        //now adding a static method
        Function<String, String> identity=Function.identity();
        //static methods can also be used as factory methods on functional interfaces

    }
}
