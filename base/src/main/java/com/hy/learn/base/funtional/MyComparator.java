package com.hy.learn.base.funtional;


/**
 * @author Created by hy
 * @date on 2020/4/22 17:12
 */
@FunctionalInterface
public interface MyComparator<T> {

    int compare(T o1, T o2);

    public static Apple get100(){
        Apple apple = new Apple();
        apple.setType(100);
        return apple;
    }

}
