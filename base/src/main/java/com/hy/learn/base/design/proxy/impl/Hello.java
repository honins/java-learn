package com.hy.learn.base.design.proxy.impl;


import com.hy.learn.base.design.proxy.IHello;

/**
 * @author Created by hy
 * @date on 2019/11/8 16:27
 */
public class Hello implements IHello {

    @Override
    public void sayHello(String name) {
        System.out.println("hello：~" + name);
    }

    @Override
    public void sayGoodBye(String name) {
        System.out.println("goodbye:"+name);
    }

}
