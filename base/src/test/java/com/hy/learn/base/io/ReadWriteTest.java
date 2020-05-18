package com.hy.learn.base.io;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author Created by hy
 * @date on 2020/5/18 11:22
 */
public class ReadWriteTest {

    @Test
    public void readFileContent() {
        try {
            ReadWrite.readFileContent("D:\\logs\\catalina\\catalina.log");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}