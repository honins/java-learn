package com.hy.learn.base.io;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;

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

    @Test
    public void byteArray(){
        String msg = "你我hello";
        InputStream inputStream = new ByteArrayInputStream(msg.getBytes());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int data;
        try {
            while ((data = inputStream.read()) != -1){
                byteArrayOutputStream.write((char)data);
            }
            byte[] bytes = byteArrayOutputStream.toByteArray();
            System.out.println(byteArrayOutputStream.toString());
            System.out.println(Arrays.toString(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}