package com.hy.learn.base.io;

import java.io.Serializable;

/**
 * @author Created by hy
 * @date on 2019/12/6 11:22
 */
public class A implements Serializable{
    private Integer x;
    private Integer y;

    A(Integer x,Integer y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "A{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

