package com.bpjoshi.java8streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Bhagwati Prasad
 * There is no value of storing stream processing different streams in variables
 * as You can process one stream only once. To do another operation ..you have to open a new stream
 * i.e. why write stream operation inline method
 */
public class StreamFirst {
    public static void main(String[] args) {
        Person p1= new Person("Ab", 25);
        Person p2= new Person("Ac", 23);
        Person p3= new Person("Ad", 27);
        Person p4= new Person("Ae", 21);
        Person p5= new Person("Af", 29);
        Person p6= new Person("Ag", 19);
        Person p7= new Person("Ah", 18);
        Person p8= new Person("", 18);
        List<Person> people= Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8);
        /*
        Stream<Person> stream = people.stream();
        Stream<String> stringStream = stream.map(p -> p.getName());
        Stream<String> stringStream1 = stringStream.filter(name -> !name.isEmpty());
        long count = stringStream1.count();
        System.out.println(count);
        */

        long count1 = people.stream()
                .map(p -> p.getName())
                .filter(s -> !s.isEmpty())
                .count();
        System.out.println(count1);
    }
}
