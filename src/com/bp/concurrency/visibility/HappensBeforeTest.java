package com.bp.concurrency.visibility;

/**
 * @author Bhagwati Prasad
 * The code works fine because variables are accessed
 * either Synchronized way or volatile way for a happens before link
 */
public class HappensBeforeTest {
    public static void main(String[] args) throws InterruptedException {
        HappensBefore v= new HappensBefore();
        Runnable runnable1= ()->{v.incrementValue();};
        Runnable runnable2=()->{v.print();};
        Thread t1=new Thread(runnable1);
        Thread t2= new Thread(runnable2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Exit ");
    }
}
