package com.bpjoshi.genprobs;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Bhagwati Prasad
 * fibonacci series: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144
 * Find nth fibonacci number
 */
public class Fibonacci {
    public static Map<Integer, Long> fibCache = new HashMap<>();
    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        long result=fibonacciNumberByIndex(100);
        long end=System.currentTimeMillis();
        System.out.println(result+" calculated in : "+(end-start)+" ms");
    }

    /**
     * calculating ith fibonacci number using memoization
     * @param i th fibonacci number you want to calculate
     * @return ith fibonacci number calculated result
     */
    public static Long fibonacciNumberByIndex(int i){
        if(i==1||i==2)
            return 1L;
        Long result= fibCache.get(i);
        if(result!=null)
            return result;
        else{
            result=fibonacciNumberByIndex(i-1)+fibonacciNumberByIndex(i-2);
            fibCache.put(i, result);
            return result;
        }
    }
}
