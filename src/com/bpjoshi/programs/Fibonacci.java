package com.bpjoshi.programs;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    /*
    Write a function 'fib(n)' that takes in a number as an argument.
The function should return n-th number of the Fibonacci sequence.

The 1st and 2nd number of the sequence is 0 and 1 respectively.
To generate the next number of the sequence, we sum the previous two.

Ex.: fib(5) -> 3, fib(7) -> 8 etc.
     */
    static Map<Integer, Long> cache= new HashMap<>();
    public static void main(String[] args) {
        long fib = fib(50);
        System.out.println(fib);
    }

    static long fib(int n){
        if(cache.containsKey(n))
            return cache.get(n);
        if(n==1)
            return 0;
        if(n==2)
            return 1;
        long fib=fib(n-1)+fib(n-2);
        cache.put(n, fib);
        return fib;
    }
}
