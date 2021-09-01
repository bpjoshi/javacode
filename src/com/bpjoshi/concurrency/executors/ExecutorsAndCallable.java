package com.bpjoshi.concurrency.executors;

import java.util.concurrent.*;

/**
 * @author Bhagwati Prasad
 * Simple Callable with ExecutorService
 */
public class ExecutorsAndCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> task= ()-> "Thread is : "+Thread.currentThread().getName();

        //ExecutorService service= Executors.newSingleThreadExecutor();
        ExecutorService service= Executors.newFixedThreadPool(4);
        for(int i=0; i<10; i++){
            Future<String> status = service.submit(task);
            System.out.println(status.get());
        }
        service.shutdown();
    }
}
