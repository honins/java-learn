package com.hy.learn.base.design.proxy;

import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Created by hy
 * @date on 2021/3/26 10:26
 */
public class JdkProxySourceClass {

    public static void writeClassToDisk(String path) {
        byte[] classFile = ProxyGenerator.generateProxyClass("$proxy1", new Class[]{IHello.class});

        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(path);
            fos.write(classFile);
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        writeClassToDisk("D:\\java\\idea_workspace\\$Proxy1.class");
    }

}
