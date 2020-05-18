package com.hy.learn.base.nio;

import com.hy.learn.base.io.ReadWrite;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Created by hy
 * @date on 2020/5/18 14:43
 */
public class MyChannel {

    public static void fastCopy(String src,String dist) throws IOException {
        FileInputStream inputStream = new FileInputStream(src);
        FileChannel fcin = inputStream.getChannel();
        FileOutputStream outputStream = new FileOutputStream(dist);
        FileChannel fcout = outputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
        int read;
        while ((read = fcin.read(byteBuffer)) != -1) {
            byteBuffer.flip();
            fcout.write(byteBuffer);
            byteBuffer.clear();
        }
    }

}
