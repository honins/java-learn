package com.hy.learn.base.concurrent;

import org.junit.Test;

/**
 * @author Created by hy
 * @date on 2020/4/29 17:43
 */
public class DemoTest {

    @Test
    public void demo() {
        Thread thread1 = new Thread(() -> buy());
        Thread thread2 = new Thread(() -> buy());
        thread1.start();
        thread2.start();
    }

    public int count = 10;

    private void buy() {
        while (count > 0) {
            count--;
            System.out.println(Thread.currentThread().getName() + " 得到了一张票，剩余 " + count);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}