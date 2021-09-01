package com.bpjoshi.concurrency.visibility;
/**
 * @author Bhagwati Prasad
 * happens before link due to x being volatile
 */
public class HappensBefore {
    volatile int x;
    public void incrementValue(){
        ++x;
    }
    public void print(){
        System.out.println(x);
    }
}
