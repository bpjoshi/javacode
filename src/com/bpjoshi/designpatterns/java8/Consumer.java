package com.bpjoshi.designpatterns.java8;

import java.util.Objects;

/**
 * @author Bhagwati Prasad
 * Sample Consumer Functional Interface with default method
 * @param <T>
 */
@FunctionalInterface
public interface Consumer<T>{
    void accept(T t);

   default Consumer<T> andThen(Consumer<T> other){
       Objects.requireNonNull(other);
       return (T t)->{
           this.accept(t);
           other.accept(t);
       };
    }
}
