package com.hy.learn.base.io;

import org.junit.Test;

import java.io.*;

/**
 * @author Created by hy
 * @date on 2020/5/18 11:34
 */
public class IoSerializableTest {

    @Test
    public void test() {
        Apple a1 = new Apple("a1", 101);
        String objectFile = "D:\\data\\object\\apple.text";

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(objectFile));
            objectOutputStream.writeObject(a1);
            objectOutputStream.close();

            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(objectFile));
            Apple a2 = (Apple) objectInputStream.readObject();
            System.out.println(a2);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}