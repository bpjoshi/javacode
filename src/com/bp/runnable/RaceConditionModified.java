package com.bp.runnable;

/**
 * @author Bhagwati Prasad
 */
public class RaceConditionModified {
    public static void main(String[] args) throws InterruptedException {
        LongWrapperModified longWrapper = new LongWrapperModified(0L);
        Runnable r=()->{
            for(int i=1; i<=1_000; i++) {
                longWrapper.increaseValue();
            }
        };
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
        //Expected value is 1 million and it gives 1 million
        System.out.println("Long Wrapper value: "+longWrapper.getL());
    }
}
