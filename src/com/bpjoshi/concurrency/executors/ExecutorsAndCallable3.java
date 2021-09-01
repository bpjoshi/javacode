package com.bpjoshi.concurrency.executors;

import java.util.concurrent.*;

/**
 * @author Bhagwati Prasad
 * Simple Callable with ExecutorService
 */
public class ExecutorsAndCallable3 {
    public static void main(String[] args) throws ExecutionException, TimeoutException, InterruptedException {
        Callable<String> task= ()-> {
            throw new IllegalStateException("Thread is : "+Thread.currentThread().getName());
        };

        ExecutorService service= Executors.newFixedThreadPool(4);
        try{
            for(int i=0; i<10; i++){
                Future<String> status = service.submit(task);
                String result = status.get();
            }
        } finally {
            service.shutdown();
        }

    }
}
