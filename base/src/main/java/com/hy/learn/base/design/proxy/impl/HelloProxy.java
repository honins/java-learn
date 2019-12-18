package com.hy.learn.base.design.proxy.impl;


import com.hy.learn.base.design.proxy.IHello;

/**
 * @author Created by hy
 * @date on 2019/11/8 16:49
 */
public class HelloProxy implements IHello {

    private Hello hello;

    public HelloProxy (Hello hello){
        this.hello = hello;
    }

    @Override
    public void sayHello(String name) {
        System.out.println("before log");
        hello.sayHello(name);
        System.out.println("after log");
    }

    @Override
    public void sayGoodBye(String name) {

    }
}
