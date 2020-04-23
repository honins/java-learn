package com.hy.learn.base.funtional;

import java.util.Comparator;

/**
 * @author Created by hy
 * @date on 2020/4/22 16:48
 */
public class DefaultMethod {

    public void comparator() {
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();

        Comparator<Apple> byWeight = (o1, o2) -> o1.getWeight() - o2.getWeight();
        int compare = byWeight.compare(apple1, apple2);
    }

}
