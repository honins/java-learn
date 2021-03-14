package com.hy.learn.base.design.proxy;

import com.hy.learn.base.design.proxy.impl.Hello;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author home-pc
 * @program: java-learn
 * @description:
 * @date 2021-03-14 20:57:19
 */
public class DynamicProxyMain {

    public static void main(String[] args) throws Throwable {
//        DynamicProxyHello dynamicProxyHello = new DynamicProxyHello();
//        Hello hello = (Hello) dynamicProxyHello.bind(new Hello());
        IHello iHello = (IHello) new DynamicProxyHello().bind(new Hello());
        iHello.sayGoodBye("abc");

        Hello hello = (Hello) new DynamicProxyHello().bind(new Hello());
        hello.sayHello("abc");

//        dynamicProxyHello.invoke(proxy, Hello.class.getMethod("sayHello", String.class), new String[]{"abc"});
    }

}
