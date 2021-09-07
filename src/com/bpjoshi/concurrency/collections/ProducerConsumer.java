package com.bpjoshi.concurrency.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author Bhagwati Prasad
 * ProducerConsumer using BlockingQueue
 */
public class ProducerConsumer {
    public static void main(String[] args) {
        BlockingQueue blockingQueue= new ArrayBlockingQueue(50);
        class Producer implements Callable<String>{

            @Override
            public String call() throws Exception {
                int count=0;
                while(count++<30){
                    blockingQueue.put(Integer.valueOf(0));
                    System.out.println(Thread.currentThread().getName()+" in production");
                }
                return "Producer done producing "+(count-1)+" strings";
            }
        }
        class Consumer implements Callable<String>{

            @Override
            public String call() throws Exception {
                int count=0;
                while(count++<30){
                    blockingQueue.take();
                    System.out.println(Thread.currentThread().getName()+" in consumption");
                }
                return "Consumer done consuming "+(count-1)+" strings";
            }
        }

        List<Callable<String>> producerConsumers= new ArrayList<>();
        for(int i=0; i<2; i++){
            producerConsumers.add(new Consumer());
        }
        for(int i=0; i<2; i++){
            producerConsumers.add(new Producer());
        }

        ExecutorService executorService= Executors.newFixedThreadPool(4);
        try{
            List<Future<String>> futures = executorService.invokeAll(producerConsumers);
            futures.forEach(future-> {
                try {
                    System.out.println(future.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            });
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            executorService.shutdown();
        }

    }
}
