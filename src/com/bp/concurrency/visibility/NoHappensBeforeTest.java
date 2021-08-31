package com.bp.concurrency.visibility;

/**
 * @author Bhagwati Prasad
 * runnable2 prints incosistently either 1 or 2
 * because there is no happens before link for the variable x
 * shared between t2 threads executing different portion of code
 * on the same object v
 */
public class NoHappensBeforeTest {
    public static void main(String[] args) throws InterruptedException {
        NoHappensBefore v= new NoHappensBefore();
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
