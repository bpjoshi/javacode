package com.bp.runnable;

/**
 * @author Bhagwati Prasad
 */
public class DeadLockTest {
    public static void main(String[] args) throws InterruptedException {
        DeadLock deadLock= new DeadLock();
        Runnable r1= ()->{deadLock.method1();};
        Runnable r2= ()-> {deadLock.method2();};
        Thread t1= new Thread(r1);
        t1.start();
        Thread t2= new Thread(r2);
        t2.start();
        //wait for threads to stop by calling join()
        t1.join();
        t2.join();
    }
}
