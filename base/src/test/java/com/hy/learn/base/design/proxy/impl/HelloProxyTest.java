package com.hy.learn.base.design.proxy.impl;

import org.testng.Assert;

import static org.testng.Assert.*;

public class HelloProxyTest {

    @org.testng.annotations.Test
    public void testSayHello() {
        HelloProxy helloProxy = new HelloProxy(new Hello());
        helloProxy.sayHello("hy");
    }
}