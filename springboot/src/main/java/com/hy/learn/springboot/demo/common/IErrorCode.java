package com.hy.learn.springboot.demo.common;

/**
 * 封装API的错误码
 * Created by macro on 2019/4/19.
 */
public interface IErrorCode {
    Integer getCode();

    String getMessage();
}