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
public class ProducerConsumer {
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
                            isEmpty.await();
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
        // if you use less number of threads let's say 4 threads only in executor thread pool
        //there is a high chance the program will enter in deadlock situation
        //because 4 threads might be busy in either consuming or producing
        //They would have reached waiting state by calling lock.await()
        //but there is no either producing or consuming thread to signal them
        //Choose appropriate number of threads according to your needs
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
