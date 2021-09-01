package com.bpjoshi.concurrency.visibility;

/**
 * @author Bhagwati Prasad
 * Q> what will be the value of r2 from HappensBeforeComplex?
 * Answer:
 * if t1 executes first, then happens before is guaranteed for x - r2 as well
 * because before entering synchronized block, x is assigned to 1 and synchronized will
 * respect our code order. i.e. we will see printed values as 1, 1, 1, 1
 * But if t2 executes first, then we don't know the exact value of r2 ..it can be either of 0 or 1
 */
public class HappensBeforeComplexTest {
    public static void main(String[] args) throws InterruptedException {
        HappensBeforeComplex v= new HappensBeforeComplex();
        Runnable runnable1= ()->{v.firstMethod();};
        Runnable runnable2=()->{v.secondMethod();};
        Thread t1=new Thread(runnable1);
        Thread t2= new Thread(runnable2);
        t1.start();
        t2.start();
        t1.join();
        System.out.println(v.x+" "+v.y+" "+v.r1+" "+v.r2);
    }
}
