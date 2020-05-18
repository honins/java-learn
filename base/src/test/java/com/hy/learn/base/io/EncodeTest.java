package com.hy.learn.base.io;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

import static org.junit.Assert.*;

/**
 * @author Created by hy
 * @date on 2020/5/18 11:07
 */
public class EncodeTest {

    @Test
    public void encode(){
        String str1 = "中文abc";
        byte[] bytes = str1.getBytes();
        try {
            String str2 = new String(bytes, "UTF-8");
            System.out.println(str2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


}