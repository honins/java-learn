package com.hy.learn.base.nio;

import com.hy.learn.base.io.IoFile;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author Created by hy
 * @date on 2020/5/18 14:52
 */
public class MyChannelTest {

    @Test
    public void fastCopy() {
        try {
            MyChannel.fastCopy("D:\\logs\\catalina\\catalina.log","D:\\logs\\catalina\\copy.log");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}