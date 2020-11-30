package com.hy.learn.base.interfaces;

/**
 * @author Created by hy
 * @date on 2020/6/1 12:43
 */
public interface Default {

    default void getDefault(String str){
        System.out.println(str);
    }

}
