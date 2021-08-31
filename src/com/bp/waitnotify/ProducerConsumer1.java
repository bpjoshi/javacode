package com.bp.waitnotify;

/**
 * @author Bhagwati Prasad
 * Naive implementation that contains race condition
 */
public class ProducerConsumer1 {
    static int[] buffer=null;
    static int count;

    static class Producer{
        void produce(){
            while(isBufferFull()){}
            buffer[count++]=1;
        }
    }
    static class Consumer{
        void consume(){
            while(isBufferEmpty()){}
            buffer[--count]=0;
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
