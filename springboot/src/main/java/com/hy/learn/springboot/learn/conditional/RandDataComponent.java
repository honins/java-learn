package com.hy.learn.springboot.learn.conditional;

import org.springframework.stereotype.Component;

import java.util.function.Supplier;

/**
 * @author Created by hy
 * @date on 2020/5/15 14:31
 */
public class RandDataComponent<T> {

    private Supplier<T> rand;

    public RandDataComponent(Supplier<T> rand) {
        this.rand = rand;
    }

    public T rand() {
        return rand.get();
    }

}
