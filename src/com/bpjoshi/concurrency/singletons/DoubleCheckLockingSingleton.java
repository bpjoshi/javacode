package com.bpjoshi.concurrency.singletons;

/**
 * @author Bhagwati Prasad
 * The below DoubleCheckLockingSingleton is safe ..but it doesn't perform well because we have made instance
 * variable volatile i.e. we will read correct value of instance
 */
public class DoubleCheckLockingSingleton {
    //We need to make it volatile, otherwise it will have bugs
    //The reason being ..if T1 thread enters synchronized zone in getInstance ..while it has not fully created object
    //Thread t2 can read the half constructed object i.e. corrupt data
    private static volatile DoubleCheckLockingSingleton instance;
    private static Object key= new Object();
    private DoubleCheckLockingSingleton(){

    }
    public static DoubleCheckLockingSingleton getInstance(){
        if(instance!=null){
            return instance;
        }
        synchronized (key){
            if(instance==null){
                instance= new DoubleCheckLockingSingleton();
            }
            return instance;
        }
    }
}
