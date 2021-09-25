package com.bpjoshi.genprobs;

public class Factorial {
    public static void main(String[] args) {
        long result=factorial(8);
        System.out.println(result);
    }

    private static long factorial(int i) {
        if(i==1)
            return 1;
        else
            return i*factorial(i-1);
    }
}
