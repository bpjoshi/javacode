package com.bp.waitnotify;

/**
 * @author Bhagwati Prasad
 * Naive implementation 2 that synchronizes on common lock object
 * lock must be same as they both share the same data i.e. buffer
 * accesses will only be synchronized if the lock is same
 * but this will be a disaster as the thread that has lock object waits inside while
 * without releasing monitor and other thread will be waiting for lock object to
 * produce or consume (depends on which thread has the lock )
 */
public class ProducerConsumer2 {
    private static final Object lock= new Object();
    static int[] buffer=null;
    static int count;

    static class Producer{
        void produce(){
            synchronized (lock){
                while(isBufferFull()){}
                buffer[count++]=1;
            }
        }
    }
    static class Consumer{
        void consume(){
            synchronized (lock){
                while(isBufferEmpty()){}
                buffer[--count]=0;
            }
        }
    }

   static boolean isBufferFull(){
        return count==buffer.length;
    }
    static boolean isBufferEmpty(){
        return count==0;
    }

    public static void main(String[] args) throws InterruptedException {
        buffer= new int[10];
        count=0;
        Producer producer= new Producer();
        Consumer consumer= new Consumer();
        Runnable producerRunnable=()->{
            for(int i=0; i<50; i++){
                producer.produce();
            }
            System.out.println("Producing finished ");
        };

        Runnable consumerRunnable=()->{
            for(int i=0; i<50; i++){
                consumer.consume();
            }
            System.out.println("Consuming finished ");
        };

        Thread producerThread= new Thread(producerRunnable);
        Thread consumerThread= new Thread(consumerRunnable);
        producerThread.start();
        consumerThread.start();
        producerThread.join();
        consumerThread.join();
        //final count should be zero
        System.out.println("final count in buffer: "+ count);
    }
}
