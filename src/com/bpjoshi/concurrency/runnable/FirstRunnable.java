package com.bpjoshi.concurrency.runnable;
/**
 * @author Bhagwati Prasad
 */
public class FirstRunnable {
    public static void main(String[] args) {
        Runnable r= ()->{
            System.out.println("Current thread name "+Thread.currentThread().getName());
        };
        Thread thread= new Thread(r);
        thread.setName("T1");
        //thread.run() doesn't launch a new thread. it will print Current Thread Name main
        //thread.run();
        thread.start();
    }
}
