package com.bp.concurrency.visibility;
/**
 * @author Bhagwati Prasad
 * This code will give inconsistent results in a multithread environment
 * there is no happens before link due to no synchronization or volatile read write
 */
public class NoHappensBefore {
    int x;
    public void incrementValue(){
        ++x;
    }
    public void print(){
        System.out.println(x);
    }
}
