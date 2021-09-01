package com.bpjoshi.concurrency.executors;

import java.util.concurrent.*;

/**
 * @author Bhagwati Prasad
 * Simple Callable with ExecutorService
 */
public class ExecutorsAndCallable2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        Callable<String> task= ()-> {
            //sleep for 500 milisecond
            Thread.sleep(500);
            return "Thread is : "+Thread.currentThread().getName();
        };

        //ExecutorService service= Executors.newSingleThreadExecutor();
        ExecutorService service= Executors.newFixedThreadPool(4);
        try{
            for(int i=0; i<10; i++){
                Future<String> status = service.submit(task);
                //below get method throws exception ..timeout exception
                String result = status.get(100,TimeUnit.MILLISECONDS);
            }
        } finally {
            service.shutdown();
        }

    }
}
