package com.bpjoshi.concurrency.executors;

import java.util.concurrent.*;

/**
 * @author Bhagwati Prasad
 * Simple Callable with ExecutorService
 */
public class ExecutorsAndCallable1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        Callable<String> task= ()-> {
            //sleep for 500 milisecond
            Thread.sleep(500);
            return "Thread is : "+Thread.currentThread().getName();
        };

        //ExecutorService service= Executors.newSingleThreadExecutor();
        ExecutorService service= Executors.newFixedThreadPool(4);
        for(int i=0; i<10; i++){
            Future<String> status = service.submit(task);
            //below get method throws exception ..timeout exception
            String result = status.get(100,TimeUnit.MILLISECONDS);
        }
        //jvm will not shutdown as there will be timeout ..because thread sleeps for 500 milliseconds while
        //future.get waits only 100 miliseconds for response for each run of submitting the task
        //We'll get java.util.concurrent.TimeoutException and jvm will not shut down
        //we need to wrap our code in finally
        service.shutdown();
    }
}
