package com.bpjoshi.concurrency.locks;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Bhagwati Prasad
 */
public class UnSafeCache {
    private Map<Long,String> cache=new HashMap<>();
    public void write(Long key, String value){
        this.cache.put(key,value);
    }
    public String retrieve(Long key){
        return this.cache.get(key);
    }

    public static void main(String[] args) {
        UnSafeCache unsafeCache= new UnSafeCache();

        class Producer implements Callable<String>{
            private Random random= new Random();
            @Override
            public String call() throws Exception {
                while(true){
                    long key= random.nextInt(1_000);
                    //Hashmap is not thread safe ..it will lead to inconsistencies
                    //some values will not be put in the map
                    unsafeCache.write(key, Long.toString(key));
                    if(unsafeCache.retrieve(key)==null){
                        System.out.println("key "+key+" has not been put on the cache");
                    }
                }
            }
        }
        ExecutorService service= Executors.newFixedThreadPool(4);
        try{
            for(int i=0; i<4; i++){
                service.submit(new Producer());
            }
        }finally {
            service.shutdown();
        }

    }
}
