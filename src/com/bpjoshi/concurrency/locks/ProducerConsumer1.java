package com.bpjoshi.concurrency.locks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Bhagwati Prasad
 */
public class ProducerConsumer1 {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> buffer= new ArrayList<>();
        Lock lock= new ReentrantLock();
        Condition isEmpty=lock.newCondition();
        Condition isFull= lock.newCondition();

        class Consumer implements Callable<String>{
            @Override
            public String call() throws Exception {
                int count=0;
                while(count++<50){
                    try{
                        lock.lock();
                        while(isEmpty(buffer)){
                            if(!isEmpty.await(10, TimeUnit.MILLISECONDS)){
                                throw new TimeoutException("consumer 10 milisecond lapsed");
                            }
                        }
                        buffer.remove(buffer.size()-1);
                        isFull.signalAll();
                    }finally{
                        lock.unlock();
                    }
                }
                return "consumed count: "+(count-1);
            }
        }

        class Producer implements Callable<String>{

            @Override
            public String call() throws Exception {
                int count=0;
                while(count++<50){
                    try{
                        lock.lock();
                        //in case of exception as below, producer thread go to finally block and release the lock
                        //Consumer threads will be waiting for the data to be available.
                        //to avoid this deadlock we have to use timedwaiting in consumer
                        final int i = 1 / 0;
                        while(isFull(buffer)){
                            isFull.await();
                        }
                        buffer.add(1);
                        isEmpty.signalAll();
                    }finally {
                        lock.unlock();
                    }
                }
                return "produced count: "+(count-1);
            }
        }

        List<Producer> producers= new ArrayList<>();
        for(int i=0; i<4; i++){
            producers.add(new Producer());
        }

        List<Consumer> consumers= new ArrayList<>();
        for(int i=0; i<4; i++){
            consumers.add(new Consumer());
        }

        List<Callable<String>> producerAndConsumers= new ArrayList<>();
        producerAndConsumers.addAll(producers);
        producerAndConsumers.addAll(consumers);
        ExecutorService service= Executors.newFixedThreadPool(8);
        try{
            List<Future<String>> futures=service.invokeAll(producerAndConsumers);
            futures.forEach(future->{
                try{
                    System.out.println(future.get());
                }catch (InterruptedException | ExecutionException e){
                    System.out.println("Exception : "+e.getMessage());
                }
            });
        }finally {
            service.shutdown();
            System.out.println("executor service shut down");
        }

    }

    private static boolean isEmpty(List<Integer> buffer) {
        return buffer.size()==0;
    }

    private static boolean isFull(List<Integer> buffer) {
        return buffer.size()==10;
    }
}
