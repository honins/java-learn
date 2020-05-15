package com.hy.learn.springboot.learn.conditional;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author Created by hy
 * @date on 2020/5/15 15:54
 */
@Component
public class TestComponent<T> {

    public Integer get(){
        return new Random().nextInt(10000);
    }

}
