package com.hy.learn.base.concurrent;

import java.util.concurrent.Callable;

/**
 * @author Created by hy
 * @date on 2020/3/23 17:39
 */
public class MyCallable implements Callable<Integer> {

    private Integer i = 0;

    @Override
    public Integer call() throws Exception {
        return ++i;
    }
}
