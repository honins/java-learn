package com.hy.learn.base.funtional;

import java.util.Comparator;

/**
 * @author Created by hy
 * @date on 2020/4/22 16:48
 */
public class DefaultMethod {

    public void comparator(Comparator<Apple> appleComparator) {
    }

    public void comparator() {
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();

        Comparator<Apple> byWeight = (o1, o2) -> o1.getWeight() - o2.getWeight();
        int compare = byWeight.compare(apple1, apple2);
        comparator((a1, a2) -> a1.getWeight() - a2.getWeight());
    }

}
