package com.abin.lee.algorithm.special.common;

/**
 * Created by abin on 2018/5/20 11:54.
 * algorithm-test1
 * com.abin.lee.algorithm.special.common
 */
public class DeadLock {
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();
    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                while(true){
                    synchronized(lock1){
                        System.out.println("lock1 enter");
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized (lock2){
                            System.out.println("lock2 enter");
                        }
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                while(true){
                    synchronized(lock2){
                        System.out.println("lock2 enter");
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized (lock1){
                            System.out.println("lock1 enter");
                        }
                    }
                }
            }
        }).start();
    }

}
