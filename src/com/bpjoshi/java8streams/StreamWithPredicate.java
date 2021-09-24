package com.bpjoshi.java8streams;

import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamWithPredicate {
    public static void main(String[] args) {
        Class<?> clazz= ArrayList.class;
        clazz.getSuperclass();
        //we will get NPE ..at the last because Object's superclass will be called
        /*
        Stream.<Class<?>>iterate(clazz, c->c.getSuperclass())
                .forEach(System.out::println);
         */
        //solution is not a predicate but a takewhile
        //which is introduced in java 9
        Stream.<Class<?>>iterate(clazz, c->c.getSuperclass())
                //.takeWhile(c->c!=null)
                .forEach(System.out::println);
    }
}
