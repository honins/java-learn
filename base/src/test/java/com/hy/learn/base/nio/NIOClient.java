package com.hy.learn.base.nio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author Created by hy
 * @date on 2020/5/18 17:52
 */
public class NIOClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream outputStream = socket.getOutputStream();
        String msg = "hello";
        outputStream.write(msg.getBytes());
        outputStream.close();
    }

}
