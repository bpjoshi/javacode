package com.bp.waitnotify;

/**
 * @author Bhagwati Prasad
 * Mature Implementation of Producer Consumer with
 * wait/notify pattern
 * when the buffer is full, producer thread waits, having notified consumer threads already at the time of producing
 * when the buffer is empty, consumer thread wait, having notified producer thread already at the time of consuming
 * we can change consumer size to validate the result i.e. easy consume only 40 then count must be 10 at the end
 */
public class ProducerConsumer3 {
    private static final Object lock= new Object();
    static int[] buffer=null;
    static int count;

    static class Producer{
        void produce() {
            synchronized (lock){
                while(isBufferFull()){
                    try{
                        lock.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                }
                buffer[count++]=1;
                lock.notify();
            }
        }
    }
    static class Consumer{
        void consume(){
            synchronized (lock){
                while(isBufferEmpty()){
                    try {
                        lock.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                }
                buffer[--count]=0;
                lock.notify();
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
