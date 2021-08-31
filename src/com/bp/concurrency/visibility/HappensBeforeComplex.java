package com.bp.concurrency.visibility;

/**
 * @author Bhagwati Prasad
 * Refer the commentary of HappensBeforeComplexTest.java
 */
public class HappensBeforeComplex {
    int x, y, r1, r2;
    private final Object lock = new Object();

    void firstMethod(){
        x=1;
        synchronized (lock){
            y=1;
        }
    }

    void secondMethod(){
        synchronized (lock){
            r1=y;
        }
        r2=x;
    }
}
