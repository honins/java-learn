package com.hy.learn.base.design.proxy;

import com.hy.learn.base.design.proxy.impl.Hello;


/**
 * @author home-pc
 * @program: java-learn
 * @description:
 * @date 2021-03-14 20:57:19
 */
public class DynamicProxyMain {

    public static void main(String[] args) {
        IHello iHello = (IHello) new HelloDynamicProxy().bind(new Hello());
        iHello.sayGoodBye("abc");
    }

}
