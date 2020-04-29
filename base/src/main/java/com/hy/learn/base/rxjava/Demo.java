package com.hy.learn.base.rxjava;

import io.reactivex.rxjava3.core.Flowable;

import java.util.ArrayList;

/**
 * @author Created by hy
 * @date on 2020/4/29 13:57
 */
public class Demo {

    public static void main(String[] args) {
        Flowable.just("Hello world").subscribe(System.out::println);
        Flowable.just("hy").subscribe(toUser -> sayHello(toUser));
        Flowable.just(1,2).subscribe(Demo::add);
    }

    private static void add(Integer integer) {
        int sum = 0;
        sum += integer;
        System.out.println(sum);
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(1);
//        ArrayList<Object> objects2 = new ArrayList<>();
//        objects = objects2;
        new Thread(() -> System.out.println(objects));

    }

    public static void sayHello(String toUser) {
        System.out.println("hello " + toUser + "!");
    }

}
