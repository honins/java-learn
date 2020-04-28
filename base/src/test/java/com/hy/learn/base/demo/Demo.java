package com.hy.learn.base.demo;

import org.junit.Test;

/**
 * @author Created by hy
 * @date on 2020/4/28 13:19
 */
public class Demo {

    @Test
    public void test1(){
        double d = 756.2345566;
        String format = String.format("%.1f", d);
        System.out.println(new Double(format));

        System.out.println(new Double(String.format("%.1f", d)));
    }

}
