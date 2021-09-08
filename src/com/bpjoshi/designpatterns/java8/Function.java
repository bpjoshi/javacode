package com.bpjoshi.designpatterns.java8;

import java.util.Objects;

/**
 * @author Bhagwati Prasad
 * Functional Interface with a default method that enables chaining
 * and composition
 * @param <T>
 * @param <R>
 */
@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);

    default <V> Function<T, V> andThen(Function<R, V> other){
        Objects.requireNonNull(other);
        return (T t)->{
            R r = this.apply(t);
            return other.apply(r);
        };
    }

    /**
     * GenericType will be derived using the calling lambdas
     * in composing you apply parameter function first
     * on the calling function and then the calling function applies
     * @param other
     * @param <V>
     * @return
     */
    default <V> Function<V,R> compose(Function<V,T> other){
        Objects.requireNonNull(other);
        return (V v)->{
            T t = other.apply(v);
            return this.apply(t);
        };
    }

    /**
     * T is only seen by Instance members
     * that's why need to add T
     * @param <T>
     * @return
     */
    static <T> Function<T, T> identity(){
        return t->t;
    }
}
