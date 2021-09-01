package com.bpjoshi.concurrency.singletons;

/**
 * @author Bhagwati Prasad
 * Obviously it doesn't perform well in multicore CPU as we can't read in parallel
 */
public class SimpleSafeSingleton {
    private static SimpleSafeSingleton instance;
    private SimpleSafeSingleton(){

    }
    public synchronized SimpleSafeSingleton getInstance(){
        if(instance==null){
            instance= new SimpleSafeSingleton();
        }
        return instance;
    }
}
