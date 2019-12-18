package com.hy.learn.base.design.proxy;

import java.lang.reflect.Method;

/**
 * @author Created by hy
 * @date on 2019/11/8 18:36
 */
public interface IOperation {

    void start(Method method);

    void end(Method method);

}
