package com.hy.learn.base.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Created by hy
 * @date on 2019/11/8 18:09
 */
public class HelloDynamicProxy implements InvocationHandler {

    private Object delegate;

    public Object bind(Object delegate) {
        this.delegate = delegate;
        return Proxy.newProxyInstance(this.delegate.getClass().getClassLoader(),
                this.delegate.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        try {
            System.out.println(method.getName()+"Method start.");
            method.invoke(this.delegate, args);
            System.out.println(method.getName()+"Method end");
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
