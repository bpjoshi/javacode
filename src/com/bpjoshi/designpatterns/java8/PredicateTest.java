package com.bpjoshi.designpatterns.java8;

/**
 * @author Bhagwati Prasad
 * Chaining Lambdas for Predicate
 */
public class PredicateTest {
    public static void main(String[] args) {
        Predicate<String> isNotEmpty=s->!s.isEmpty();
        Predicate<String> isNotNull=s->s!=null;
        //chaining to make isNotNullAndNotEmpty
        Predicate<String> nonNullOrEmpty=isNotEmpty.and(isNotNull);
        System.out.println(nonNullOrEmpty.test("Hello"));
        System.out.println(nonNullOrEmpty.test(""));
    }
}
