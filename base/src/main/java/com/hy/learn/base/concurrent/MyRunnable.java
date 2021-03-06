package com.hy.learn.base.concurrent;

/**
 * @author Created by hy
 * @date on 2020/3/23 17:35
 */
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("MyRunnable::run");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }
}
