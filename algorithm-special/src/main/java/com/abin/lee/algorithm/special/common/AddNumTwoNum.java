package com.abin.lee.algorithm.special.common;

/**
 * Created by abin on 2018/5/18 23:02.
 * algorithm-test1
 * com.abin.lee.algorithm.special.test
 */
public class AddNumTwoNum  {
    private Object lock = new Object();
    private volatile int num = 0 ;

    public static void main(String[] args) {
        final AddNumTwoNum addNumTwoNum = new AddNumTwoNum();
        new Thread(new Runnable() {
            public void run() {
                try {
                    addNumTwoNum.qi();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                try {
                    addNumTwoNum.ou();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void qi() throws InterruptedException {
        while(num < 100){
            synchronized(lock){
                if(num % 2 != 0){
                    System.out.println("Ji----Thread=" + Thread.currentThread().getName()+"  ,num=" + (++num));
                    lock.notify();
                }
                lock.wait();
            }
        }
    }
    public void ou() throws InterruptedException {
        while(num < 100){
            synchronized(lock){
                if(num % 2 == 0){
                    System.out.println("Ou----Thread=" + Thread.currentThread().getName()+"  ,num=" + (++num));
                    lock.notify();
                }
                lock.wait();
            }
        }
    }

}
