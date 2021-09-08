package com.bpjoshi.designpatterns.java8;

/**
 * @author Bhagwati Prasad
 * Example of Chaining two consumer and why the API default methods make it easy by the use of default methods
 */
public class ConsumerTest {
    public static void main(String[] args) {
        Consumer<String> c1=s->System.out.println("C1-> "+s);
        Consumer<String> c2=s->System.out.println("C2-> "+s);
        //chaining to combine both
        Consumer<String> c3=c1.andThen(c2);
        c3.accept("Hey There!");
    }
}
