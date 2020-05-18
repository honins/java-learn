package com.hy.learn.base.io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author Created by hy
 * @date on 2020/5/18 9:35
 */
public class IoFileTest {

    @Test
    public void listAllFiles(){
        File file = new File("D:\\logs");
        IoFile.listAllFiles(file);
    }

    @Test
    public void copyFile() throws IOException {
        IoFile.copyFile("D:\\logs\\catalina\\catalina.log","D:\\logs\\catalina\\copy.log");
    }

}