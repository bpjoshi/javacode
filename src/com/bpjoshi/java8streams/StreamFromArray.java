package com.bpjoshi.java8streams;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author Bhagwati Prasad
 * Creating streams from arrays
 */
public class StreamFromArray {
    public static void main(String[] args) {
        Person p1= new Person("Ab", 25);
        Person p2= new Person("Ac", 23);
        Person p3= new Person("Ad", 27);
        Person p4= new Person("Ae", 21);
        Person p5= new Person("Af", 29);
        Person p6= new Person("Ag", 19);
        Person p7= new Person("Ah", 18);
        Person p8= new Person("Ai", 18);

        Person[] people= {p1, p2, p3, p4, p5, p6, p7, p8};

        long count = Stream.of(people).count();
        System.out.println(count);

        Arrays.stream(people).forEach(System.out::print);
    }
}
