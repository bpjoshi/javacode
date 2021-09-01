package com.bpjoshi.concurrency.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsAndRunnable {
    public static void main(String[] args) {
        Runnable r= ()-> System.out.println("Current Thread is: "+Thread.currentThread().getName());
        /*
         * Creates 10 new threads and vm shut downs once the execution is done
         */

       /* for(int i=0; i<10; i++){
            new Thread(r).start();
        }*/

        //Creates a new thread pool with a single thread
        //factory method of Executors class
        //But the java vm doesn't shut down
        ExecutorService executorServic= Executors.newSingleThreadExecutor();
        for(int i=0; i<10; i++){
            executorServic.execute(r);
        }
        //below code will shut the jvm down
        executorServic.shutdown();

        //Using a pool of more than 1
        ExecutorService service= Executors.newFixedThreadPool(4);
        for(int i=0; i<10; i++){
            service.execute(r);
        }
        service.shutdown();
    }
}
