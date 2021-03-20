package com.hy.learn.base.concurrent;

/**
 * @author Created by hy
 * @date on 2020/3/23 17:47
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        super.run();
        System.out.println(Thread.currentThread().getName());
        System.out.println("aaaaaaaaa");
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("lambda");
        }).start();
    }
}
