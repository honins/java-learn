package com.hy.learn.base.funtional;

import org.apache.logging.log4j.core.util.JsonUtils;
import org.junit.Test;

/**
 * @author Created by hy
 * @date on 2020/4/23 8:50
 */
public class MyComparatorTest {


    @Test
    public void test1() {
        Apple apple1 = new Apple();
        apple1.setType(111);
        Apple apple2 = new Apple();
        apple2.setType(222);
        MyComparator<Apple> myComparator = (o1, o2) -> o1.getType() + o2.getType();

        Apple apple3 = new Apple();
        apple3.setType(333);
        Apple apple4 = new Apple();
        apple4.setType(444);
        int compare = myComparator.compare(apple1, apple4);
        System.out.println(compare);
        Apple apple = MyComparator.get100();
    }

}