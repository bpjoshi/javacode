package com.bp.runnable;

/**
 * @author Bhagwati Prasad
 */
public class DeadLock {
    private final Object key1=new Object();
    private final Object key2= new Object();

    public void method1(){
        synchronized (key1){
            System.out.println("The current thread is: "+Thread.currentThread().getName()+" method name: method1");
            method2();
        }
    }
    public void method2(){
        synchronized (key2){
            System.out.println("The current thread is: "+Thread.currentThread().getName()+" method name: method2");
            method3();
        }
    }
    public void method3(){
        synchronized (key1){
            System.out.println("The current thread is: "+Thread.currentThread().getName()+" method name: method3");
        }
    }
}
