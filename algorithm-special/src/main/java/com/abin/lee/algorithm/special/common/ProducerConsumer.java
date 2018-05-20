package com.abin.lee.algorithm.special.common;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by abin on 2018/5/19 20:49.
 * algorithm-test1
 * com.abin.lee.algorithm.special.common
 */
public class ProducerConsumer {

    private static BlockingQueue<String> queue = new ArrayBlockingQueue<String>(3);

    public static class Producer extends Thread {

        public void put() throws InterruptedException {
            while (true) {
                synchronized (queue) {
                    if (queue.size() == 10) {
                        queue.wait();
                    }
                    queue.put("something");
                    System.out.println("put something");
                    Thread.sleep((long) (Math.random() * 3000));
                    queue.notify();
                }
            }
        }
    }

    public static class Consumer extends Thread {
        public void get() throws InterruptedException {
            while (true) {
                synchronized (queue) {
                    if (queue.size() == 0) {
                        queue.wait();
                    }
                    String result = queue.take();
                    System.out.println("take something :" + result);
                    Thread.sleep((long) (Math.random() * 3000));
                    queue.notify();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final Producer producer = new Producer();
        new Thread(new Runnable() {
            public void run() {
                try {
                    producer.put();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        final Consumer consumer = new Consumer();
        new Thread(new Runnable() {
            public void run() {
                try {
                    consumer.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


}
