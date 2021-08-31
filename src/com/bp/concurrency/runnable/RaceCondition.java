package com.bp.concurrency.runnable;

/**
 * @author Bhagwati Prasad
 */
public class RaceCondition {
    public static void main(String[] args) throws InterruptedException {
        LongWrapper longWrapper= new LongWrapper(0L);
        Runnable r=()->{
            for(int i=1; i<=1_000; i++){
                longWrapper.increaseValue();
            }
        };
        //below will work fine in one thread
        /*
        Thread t= new Thread(r);
        t.start();
        t.join(); //code below excutes only after thread t has finished
        System.out.println("LongWrapper value: "+longWrapper.getL());
        */
        //try with 1000 threads
        Thread[] threads= new Thread[1000];
        //start all the 100 threads with runnable r
        for(int i=0; i<1_000; i++){
            threads[i]= new Thread(r);
            threads[i].start();
        }
        //join all the threads to make sure they've executed runnable r
        for(int i=0; i< threads.length; i++){
            threads[i].join();
        }
        //Expected value is 1000*1000 i.e. 1 million, but it doesn't come like that
        System.out.println("Long Wrapper value: "+longWrapper.getL());
    }
}
