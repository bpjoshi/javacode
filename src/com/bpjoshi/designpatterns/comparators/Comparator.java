package com.bpjoshi.designpatterns.comparators;

import java.util.Objects;
import java.util.function.Function;

/**
 * @author Bhagwati Prasad
 * @param <T> takes param of T type
 */
@FunctionalInterface
public interface Comparator<T> {
    int compare(T t1, T t2);

    /**
     * Added in Comparator in ComparatorTest2 class
     * making it a comparator factor
     * @param extractor
     * @return One of negative, 0 or positive value
     */
    /*static <T> Comparator<T> comparing(Function<T, String> extractor) {
        Objects.requireNonNull(extractor);
        return (p1, p2) ->{
             String s1 = extractor.apply(p1);
             String s2 = extractor.apply(p2);
            return s1.compareTo(s2);
        };
    }*/
    static <T, U extends Comparable<U>> Comparator<T> comparing(Function<T, U> extractor) {
        Objects.requireNonNull(extractor);
        return (p1, p2) ->{
            U s1 = extractor.apply(p1);
            U s2 = extractor.apply(p2);
            return s1.compareTo(s2);
        };
    }

   default Comparator<T> reversed(){
       return (t1, t2)-> this.compare(t2,t1);
   }

    /**
     * comparator
     * @param other
     * @return combining two comparators
     */
   default Comparator<T> thenComparing(Comparator<T> other){
       Objects.requireNonNull(other);
        return (T t1, T t2)->{
            int compare = this.compare(t1, t2);
            if(compare==0) return other.compare(t1,t2);
            else return compare;
        };
   }

    default <U extends Comparable<U>> Comparator<T> thenComparing(Function<T,U> extractor){
        Objects.requireNonNull(extractor);
        Comparator<T> other = comparing(extractor);
        return this.thenComparing(other);
    }
}
