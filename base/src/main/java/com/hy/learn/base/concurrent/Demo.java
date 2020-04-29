package com.hy.learn.base.concurrent;


import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author Created by hy
 * @date on 2020/4/28 14:06
 */
public class Demo {

    static volatile Helper helper = new Helper();
    static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("thread-call-runner-%d").build();
    static ExecutorService taskExe = new ThreadPoolExecutor(10, 20, 200L,
            TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), namedThreadFactory);

    public static void main(String[] args) {
        taskExe.submit(() -> {
            {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0) {
                        System.out.println("set 111111");
                        helper.setName("111111");
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (i % 2 == 1) {
                        System.out.println("set 222");
                        helper.setName("222");
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        taskExe.submit(() -> {
            {
                while (true) {
                    System.out.println(helper.getName());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }

//    public static void main(String[] args) {
//        Thread thread1 = new Thread(() -> buy());
//        Thread thread2 = new Thread(() -> buy());
//        thread1.start();
//        thread2.start();
//    }
//
//    public static int count = 10;
//
//    private static void buy() {
//        while (count > 0) {
//            count--;
//            System.out.println(Thread.currentThread().getName() + " 得到了一张票，剩余 " + count);
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }

}
