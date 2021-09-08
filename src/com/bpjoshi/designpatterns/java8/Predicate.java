package com.bpjoshi.designpatterns.java8;

import java.util.Objects;

/**
 * @author Bhagwati Prasad
 * Sample Predicate functional interface with chaining
 * @param <T>
 */
@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);

   default Predicate<T> and(Predicate<T> other){
       Objects.requireNonNull(other);
       return (T t)->
            this.test(t)&&other.test(t);
    }
}
