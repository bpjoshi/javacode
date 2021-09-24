package com.bpjoshi.genprobs;

public class JavaDeadLockSolution {
    public void method1() {
        synchronized (String.class) {
            System.out.println("Aquired lock on String.class object");
            synchronized (Integer.class) {
                System.out.println("Aquired lock on Integer.class object");
            }
        }
    }
    public void method2() {
        synchronized (String.class) {
            System.out.println("Aquired lock on Integer.class object");
            synchronized (Integer.class) {
                System.out.println("Aquired lock on String.class object");
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        JavaDeadLockSolution deadLockObject= new JavaDeadLockSolution();
        Runnable r1= ()->deadLockObject.method1();
        Runnable r2=()->deadLockObject.method2();
        Thread t1= new Thread(r1);
        Thread t2= new Thread(r2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("exit");
    }
}
