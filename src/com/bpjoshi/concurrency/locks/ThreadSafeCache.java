package com.bpjoshi.concurrency.locks;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Bhagwati Prasad
 * Thread safe cache with read/write lock
 */
public class ThreadSafeCache {
    private Map<Long,String> cache=new HashMap<>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private Lock readLock=lock.readLock();
    private Lock writeLock=lock.writeLock();
    public String write(Long key, String value){
        writeLock.lock();
        try{
            return this.cache.put(key,value);
        }finally {
            writeLock.unlock();
        }
    }
    public String retrieve(Long key){
        readLock.lock();
        try{
            return this.cache.get(key);
        }finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadSafeCache safeCache= new ThreadSafeCache();

        class Producer implements Callable<String>{
            private Random random= new Random();
            @Override
            public String call() throws Exception {
                while(safeCache.cache.entrySet().size()<1000){
                    long key= random.nextInt(1_000);
                    safeCache.write(key, Long.toString(key));
                    if(safeCache.retrieve(key)==null){
                        System.out.println("key "+key+" has not been put on the cache");
                    }
                }
                return "cache is full";
            }
        }
        ExecutorService service= Executors.newFixedThreadPool(4);
        Future<String> submit = null;
        try{
            for(int i=0; i<4; i++){
                submit = service.submit(new Producer());
            }
        }finally {
            System.out.println(submit.get());
            service.shutdown();
        }
        System.out.println("Size of cache "+safeCache.cache.keySet().size());
    }
}
